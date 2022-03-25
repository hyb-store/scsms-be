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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override //查找该用户对应的salecar信息
    public Map<String, List<Order>> getOrder(Integer id) {
        //查询order表中buyerid和sellerId等于id的所有信息（可能既是买家，也是卖家）
        List<Order> buyOrder = orderMapper.getBuyOrder(id);
        List<Order> saleOrder = orderMapper.getSaleOrder(id);
        HashMap<String, List<Order>> order = new HashMap<>();
        order.put("buyOrder", buyOrder);
        order.put("saleOrder", saleOrder);
        return order;
    }
}
