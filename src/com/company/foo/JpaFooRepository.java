package com.company.foo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Profile("prod")
@Repository("jpaFooRepository")
@Qualifier("JPA")
public class JpaFooRepository implements FooRepository {

    public JpaFooRepository() {
        System.out.println("Creating JPA Foo Repository...");
    }

    @Override
    public Foo save(Foo foo) {
        // TODO: Implement JPA persistence logic
        System.out.println("Saved by JPA repository: " + foo.getName());
        return foo;
    }
}
