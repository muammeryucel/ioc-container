package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class JpaFooRepository implements FooRepository {

    public JpaFooRepository() {
        System.out.println("Creating JPA Foo Repository...");
    }

    @Override
    public Foo save(Foo foo) {
        // TODO: Implement JPA persistence logic
        return foo;
    }
}
