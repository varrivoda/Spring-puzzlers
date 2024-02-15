package puzzlers.p2_audit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

//@PropertySource("application.properties")
@Service
public class MyCoolServiceImpl implements MyCoolService{
    //@Autowired
    private String conference;// = "Joker";

    @Audit
    public void pay(){
        System.out.println("pay() " + conference);
    }

    @PostConstruct
    public void setup(){
        System.out.println("setup()");
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("p2.xml");
        context.getBean(MyCoolService.class).pay();
    }

    public void setConference(String conference) {
        this.conference = conference;
    }
}
