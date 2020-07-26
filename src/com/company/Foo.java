package com.company;

public class Foo {

    private Long id;

    private String name;

    protected Foo() {
        super();
    }

    public Foo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    void setId(Long id) {
        this.id = id;
    }
}