package com.company;

import org.springframework.beans.factory.config.AbstractFactoryBean;

public class FooRepositoryFactoryBean extends AbstractFactoryBean<FooRepository> {

    @Override
    public Class<?> getObjectType() {
        return FooRepository.class;
    }

    @Override
    protected FooRepository createInstance() throws Exception {

        System.out.println("The repository instance is being created by the factory bean...");

        return new InMemoryFooRepository();
    }

}
