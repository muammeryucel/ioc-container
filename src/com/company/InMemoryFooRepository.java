package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryFooRepository implements FooRepository {

    private static AtomicLong ID_GENERATOR = new AtomicLong(0L);
    private Map<Long, Foo> storage = new HashMap<>();

    @Override
    public Foo save(Foo foo) {
        Long id = ID_GENERATOR.getAndIncrement();
        foo.setId(id);
        storage.put(id, foo);
        return foo;
    }
}
