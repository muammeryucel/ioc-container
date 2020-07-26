package com.company;

public class FooService {

    private final FooRepository repository;

    public FooService() {
        ServiceLocator serviceLocator = ServiceLocator.getInstance();
        this.repository = serviceLocator.getFooRepository();
    }

    public Foo createFoo(String foo) {
        return repository.save(new Foo(foo));
    }
}