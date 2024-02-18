package puzzlers.p2_audit;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PayInformatorAspect {
    @Pointcut("execution(* pay*(..))")
    void allPayMethods(){
        System.out.println("allPayMethods aspect");
    }

    @After("allPayMethods()")
    public void sendMailToManager(){
        System.out.println("еще один билет прдали");
    }

}
