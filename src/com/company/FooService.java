package com.company;

public class FooService {

    private final FooRepository repository;

    public FooService(FooRepository repository) {
        this.repository = repository;
    }

    public Foo createFoo(String foo) {
        return repository.save(new Foo(foo));
    }
}