package com.cuprumz.transaction.connection;

import org.junit.Test;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import java.lang.reflect.Method;

public class App {

    @Test
    public void tst() {
        for (Method m : TransactionInterceptor.class.getDeclaredMethods()) {
            System.out.println(m.getName());
        }
    }
}
