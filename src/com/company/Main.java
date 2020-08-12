package com.company;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        System.setProperty("spring.profiles.active", "dev");

        ClassPathXmlApplicationContext appContext =
                new ClassPathXmlApplicationContext("classpath:spring-config.xml");
        appContext.registerShutdownHook();

        System.out.println("Application context created!\n-------------------------");

        System.out.println("Singleton date time: " + appContext.getBean("singletonDateTime"));
        System.out.println("Prototype date time: " + appContext.getBean("prototypeDateTime"));
        System.out.println("Singleton date time: " + appContext.getBean("singletonDateTime"));
        System.out.println("Prototype date time: " + appContext.getBean("prototypeDateTime"));
        System.out.println("Singleton date time: " + appContext.getBean("singletonDateTime"));
        System.out.println("Prototype date time: " + appContext.getBean("prototypeDateTime"));
        System.out.println("Singleton date time: " + appContext.getBean("singletonDateTime"));
        System.out.println("Prototype date time: " + appContext.getBean("prototypeDateTime"));


        FooService service = appContext.getBean("fooService", FooService.class);

        System.out.println("FooService obtained!");

        service.createFoo("test");
    }
}
