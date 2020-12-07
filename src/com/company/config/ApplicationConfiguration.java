package com.company.config;

import org.h2.jdbcx.JdbcConnectionPool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
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

    @Bean
    public DataSource dataSource(@Value("${dataSource.url}") String url,
                                 @Value("${dataSource.username}") String username,
                                 @Value("${dataSource.password}") String password) {
        return JdbcConnectionPool.create(url, username, password);
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
