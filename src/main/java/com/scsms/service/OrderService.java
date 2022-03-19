package com.scsms.service;

import com.scsms.pojo.Order;

import java.util.List;

public interface OrderService {

    public List<Order> getOrder(Integer id);
}
