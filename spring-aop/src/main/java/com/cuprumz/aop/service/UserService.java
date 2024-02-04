package com.cuprumz.aop.service;

import com.cuprumz.aop.pojo.User;

public interface UserService {

    User createUser(String firstName, String lastName, int age);

    User queryUser();
}
