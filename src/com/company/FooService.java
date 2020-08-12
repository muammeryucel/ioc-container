package com.company;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.time.LocalDateTime;
import java.util.List;

public class FooService implements InitializingBean, DisposableBean {

    private final FooRepository repository;
    private List<String> someProperty;

    public FooService(FooRepository repository) {
        this.repository = repository;
        System.out.println("FooService created!");
    }

    public void setSomeProperty(List<String> someProperty) {
        this.someProperty = someProperty;
    }

    public void initMethod() {
        System.out.println("Initializing by initMethod()...");
    }

    public void destroyMethod() {
        System.out.println("Destroying by destroyMethod()...");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Initializing by @PostConstruct...");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Destroying by @PreDestroy...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing by InitializingBean...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Destroying by DisposibleBean...");
    }

    protected LocalDateTime getSingletonDateTime() {
        return null;
    }

    protected LocalDateTime getPrototypeDateTime() {
        return null;
    }

    public String replacedMethod(String param) {
        return "Original method called with " + param;
    }

    public Foo createFoo(String foo) {

        System.out.println("Some Property: " + someProperty);

        System.out.println("Lookup Singleton date time: " + getSingletonDateTime());
        System.out.println("Lookup Prototype date time: " + getPrototypeDateTime());
        System.out.println("Lookup Singleton date time: " + getSingletonDateTime());
        System.out.println("Lookup Prototype date time: " + getPrototypeDateTime());
        System.out.println("Lookup Singleton date time: " + getSingletonDateTime());
        System.out.println("Lookup Prototype date time: " + getPrototypeDateTime());
        System.out.println("Lookup Singleton date time: " + getSingletonDateTime());
        System.out.println("Lookup Prototype date time: " + getPrototypeDateTime());

        System.out.println("Replaced Method: " + replacedMethod("test"));

        return repository.save(new Foo(foo));
    }
}