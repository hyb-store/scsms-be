package com.scsms.service;

import com.scsms.pojo.Order;
import com.scsms.pojo.SaleCar;

import java.util.List;
import java.util.Map;

public interface OrderService {
    /**
     * 买车记录和买车记录
     * @param id
     * @return
     */
    public Map<String, List<Order>> getOrder(Integer id);

    public void insertOrder(SaleCar saleCar, Integer buyerId);
}
