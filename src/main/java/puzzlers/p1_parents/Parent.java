package puzzlers.p1_parents;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

public class Parent {
    @PostConstruct
    public void init(){
        System.out.println("Папа");
    }
}

