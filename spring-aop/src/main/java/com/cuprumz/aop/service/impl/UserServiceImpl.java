package com.cuprumz.aop.service.impl;

import com.cuprumz.aop.pojo.User;
import com.cuprumz.aop.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public User createUser(String firstName, String lastName, int age) {
        return new User();
    }

    @Override
    public User queryUser() {
        return new User();
    }
}
