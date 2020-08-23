package com.company.foo;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.time.LocalDateTime;
import java.util.List;

@Lazy
@Service("fooService")
public class FooService implements InitializingBean, DisposableBean {

    @Autowired
    private ApplicationContext applicationContext;

//    @Autowired(required = false)
    private FooRepository repository;
    private List<String> someProperty;

    private List<FooRepository> repositories;

    @Autowired
    public void setRepositories(List<FooRepository> repositories) {
        this.repositories = repositories;
    }

    //    @Autowired
    public FooService(@Qualifier("in-memory") FooRepository repository) {
        this.repository = repository;
        System.out.println("FooService created!");
    }

/*    @Autowired
    public void setRepository(FooRepository repository) {
        this.repository = repository;
    }*/

    @Value("#{'${some.property},Test 123,Test 456'.split(',')}")
    public void setSomeProperty(List<String> someProperty) {
        this.someProperty = someProperty;
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
        System.out.println("Destroying by DisposableBean...");
    }

    @Lookup("singletonDateTime")
    protected LocalDateTime getSingletonDateTime() {
        return null;
    }

    @Lookup("prototypeDateTime")
    protected LocalDateTime getPrototypeDateTime() {
        return null;
    }

    public String replacedMethod(String param) {
        return "Replaced method called with " + param;
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