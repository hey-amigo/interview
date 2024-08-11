package ru.sber.interview.spring;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.util.UUID;

//@SpringBootApplication
public class SecondQuestion {
    @Bean("second")
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public UUID sampleBean() {
        return UUID.randomUUID();
    }

    public static void main(String[] args) {
        SpringApplication.run(SecondQuestion.class, args);

        var context = new AnnotationConfigApplicationContext(SecondQuestion.class);
        var firstBean = context.getBean("second");
        var secondBean = context.getBean("second");

        System.out.println(firstBean);
        System.out.println(secondBean);


    }
}
