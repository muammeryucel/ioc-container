package com.company;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class RepositoryWrapper implements FooRepository {

    private final FooRepository delegate;

    public RepositoryWrapper(FooRepository delegate) {
        this.delegate = delegate;
    }

    @Override
    public Foo save(Foo foo) {

        System.out.println("Repository wrapped! Calling delegate...");

        return delegate.save(foo);
    }

    public static class PostProcessor implements BeanPostProcessor {

        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
            if(bean instanceof FooRepository) {
                return new RepositoryWrapper((FooRepository) bean);
            } else {
                return bean;
            }
        }
    }
}
