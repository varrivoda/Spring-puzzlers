package puzzlers.p2_audit;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//@Component
public class AuditBPP implements BeanPostProcessor {
    @Autowired
    private AuditManager auditManager;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class beanClass = bean.getClass();
        Method[] methods = beanClass.getMethods();
        for (Method method : methods) {
            if(method.isAnnotationPresent(Audit.class)){
                return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object returnValue = method.invoke(bean, args);
                        auditManager.audit(returnValue);
                        return returnValue;
                    }
                });
            }
        }
        return bean;
    }

}
