package com.company;

public class Main {

    public static void main(String[] args) {

        System.setProperty("profile", "dev");

        FooService service = new FooService();
        service.createFoo("test");
    }
}
