package com.company;

import com.company.config.ApplicationConfiguration;
import com.company.foo.FooService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        System.setProperty("spring.profiles.active", "dev");

        AnnotationConfigApplicationContext appContext =
                new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        appContext.registerShutdownHook();

        System.out.println("Application context created!\n-------------------------");

        FooService service = appContext.getBean("fooService", FooService.class);

        System.out.println("FooService obtained!");

        service.createFoo("test");
    }
}
