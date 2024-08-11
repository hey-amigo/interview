package ru.sber.interview.spring;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.util.UUID;

//@SpringBootApplication
public class FirstQuestion {

    @Bean("first")
    public UUID sampleBean(){
        return UUID.randomUUID();
    }

    public static void main(String[] args) {
        SpringApplication.run(FirstQuestion.class, args);

        var context = new AnnotationConfigApplicationContext(FirstQuestion.class);
        var firstBean = context.getBean("first");
        var secondBean = context.getBean("first");

        System.out.println(firstBean);
        System.out.println(secondBean);



    }
}
