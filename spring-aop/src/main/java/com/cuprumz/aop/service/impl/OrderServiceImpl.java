package com.cuprumz.aop.service.impl;

import com.cuprumz.aop.pojo.Order;
import com.cuprumz.aop.service.OrderService;

public class OrderServiceImpl implements OrderService {
    @Override
    public Order createOrder(String username, String product) {
        return new Order();
    }

    @Override
    public Order queryOrder(String username) {
        return new Order();
    }
}
