package com.cuprumz.aop.service;

import com.cuprumz.aop.pojo.Order;

public interface OrderService {


    Order createOrder(String username, String product);

    Order queryOrder(String username);
}
