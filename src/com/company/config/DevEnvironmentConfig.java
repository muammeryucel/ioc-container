package com.company.config;

import com.company.foo.FooRepository;
import com.company.foo.InMemoryFooRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DevEnvironmentConfig {

    @Profile("dev")
    @Bean("inMemoryFooRepository")
    @Qualifier("in-memory")
    protected FooRepository inMemoryFooRepository() {
        System.out.println("The repository instance is being created for development...");
        return new InMemoryFooRepository();
    }
}
