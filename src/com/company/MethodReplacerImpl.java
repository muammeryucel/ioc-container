package com.company;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;
import java.util.Arrays;

public class MethodReplacerImpl implements MethodReplacer {

    @Override
    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        return "Method reimplemented! Params: " + Arrays.asList(objects);
    }
}
