package com.company;

import java.io.InputStream;
import java.util.Properties;

public class ServiceLocator {

    private static final ServiceLocator INSTANCE = new ServiceLocator();

    public static ServiceLocator getInstance() {
        return INSTANCE;
    }

    private FooRepository fooRepository;

    private ServiceLocator() {
        try {
            String profile = System.getProperty("profile");
            InputStream is = this.getClass().getClassLoader()
                    .getResourceAsStream(
                            "service." + profile + ".properties");
            Properties properties = new Properties();
            properties.load(is);
            String className = properties.getProperty("fooRepository");
            this.fooRepository = (FooRepository) Class.forName(className)
                    .getDeclaredConstructor().newInstance();
        } catch (Exception ex) {
            throw new IllegalStateException("Unable to create service locator.", ex);
        }
    }

    public FooRepository getFooRepository() {
        return fooRepository;
    }
}
