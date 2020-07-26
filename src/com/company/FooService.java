package com.company;

public class FooService {

    private final FooRepository repository;

    public FooService() {
        this.repository = createFooRepository();
    }

    private FooRepository createFooRepository() {
        String profile = System.getProperty("profile");
        if("dev".equals(profile)) {
            return new InMemoryFooRepository();
        } else if ("prod".equals(profile)) {
            return new JpaFooRepository();
        } else {
            throw new IllegalStateException("Unable to create repository for profile: " + profile);
        }
    }

    public Foo createFoo(String foo) {
        return repository.save(new Foo(foo));
    }
}