package com.scsms.service.impl;

import com.scsms.mapper.OrderMapper;
import com.scsms.mapper.SaleCarMapper;
import com.scsms.pojo.Order;
import com.scsms.pojo.SaleCar;
import com.scsms.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> getOrder(Integer id) {

        //查询order表中buyerid和sellerId等于id的所有信息
        Order order = orderMapper.getOrder(id);
        return null;
    }
}
