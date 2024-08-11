package ru.sber.interview.spring;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
class Third1 {

    @Lookup
    public Third2 getPrototype(){
        return null;
    }

    public UUID m() {
        Third2 third2 = getPrototype();
        return third2.getId();
    }
}

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
class Third2 {

    private UUID id;

    @PostConstruct
    private void postConstruct() {
        id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

}

@SpringBootApplication
public class ThirdQuestion {

    public static void main(String[] args) {
        SpringApplication.run(ThirdQuestion.class, args);

        var context = new AnnotationConfigApplicationContext(ThirdQuestion.class);
        var firstBean = context.getBean(Third1.class);
        var secondBean = context.getBean(Third1.class);

        System.out.println(firstBean.m());
        System.out.println(secondBean.m());

    }
}