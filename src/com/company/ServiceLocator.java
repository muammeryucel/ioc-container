package com.company;

import java.io.InputStream;
import java.util.Properties;

public class ServiceLocator {

    private static final ServiceLocator INSTANCE = new ServiceLocator();

    public static ServiceLocator getInstance() {
        return INSTANCE;
    }

    private FooRepository fooRepository;
    private FooService fooService;

    private ServiceLocator() {
        try {
            String profile = System.getProperty("profile");
            InputStream is = this.getClass().getClassLoader()
                    .getResourceAsStream(
                            "service." + profile + ".properties");
            Properties properties = new Properties();
            properties.load(is);

            this.fooRepository = (FooRepository) Class.forName(properties.getProperty("fooRepository"))
                    .getDeclaredConstructor().newInstance();

            this.fooService = (FooService) Class.forName(properties.getProperty("fooService"))
                    .getDeclaredConstructor(FooRepository.class).newInstance(fooRepository);

        } catch (Exception ex) {
            throw new IllegalStateException("Unable to create service locator.", ex);
        }
    }

    public FooRepository getFooRepository() {
        return fooRepository;
    }

    public FooService getFooService() {
        return fooService;
    }
}
