package com.company;

public class Main {

    public static void main(String[] args) {

        System.setProperty("profile", "dev");

        ServiceLocator serviceLocator = ServiceLocator.getInstance();

        FooService service = serviceLocator.getFooService();
        service.createFoo("test");
    }
}
