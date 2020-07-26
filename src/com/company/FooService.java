package com.company;

public class FooService {

    private final FooRepository repository;

    public FooService() {
        this.repository = new InMemoryFooRepository();
    }

    public Foo createFoo(String foo) {
        return repository.save(new Foo(foo));
    }
}