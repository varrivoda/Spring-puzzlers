package puzzlers.p1_parents;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Son extends Parent {

    @PostConstruct
    public void init() {
        System.out.println("Ñûí");
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("puzzlers.p1_parents");
        context.getBean(Son.class);
    }
}


