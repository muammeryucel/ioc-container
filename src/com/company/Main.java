package com.company;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        System.setProperty("spring.profiles.active", "dev");

        ClassPathXmlApplicationContext appContext =
                new ClassPathXmlApplicationContext("classpath:spring-config.xml");

        FooService service = appContext.getBean(FooService.class);
        service.createFoo("test");
    }
}
