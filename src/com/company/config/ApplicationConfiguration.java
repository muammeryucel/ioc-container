package com.company.config;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.util.PropertyPlaceholderHelper;

import java.time.LocalDateTime;

@Configuration
@ComponentScan("com.company.foo")
@Import(DevEnvironmentConfig.class)
public class ApplicationConfiguration {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer bean = new PropertySourcesPlaceholderConfigurer();
        bean.setIgnoreResourceNotFound(true);
        bean.setLocations(new ClassPathResource("application.properties"),
                new FileSystemResource("/home/myucel/overridden.properties"));
        return bean;
    }

    @Bean
    @Scope("singleton")
    public LocalDateTime singletonDateTime() {
        return LocalDateTime.now();
    }

    @Bean
    @Scope("prototype")
    public LocalDateTime prototypeDateTime() {
        return LocalDateTime.now();
    }
}
