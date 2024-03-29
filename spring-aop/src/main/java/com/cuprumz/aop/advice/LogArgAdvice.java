package com.cuprumz.aop.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

public class LogArgAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("准备执行方法: " + method.getName() + ", 参数列表: " + Arrays.toString(objects));
    }
}
