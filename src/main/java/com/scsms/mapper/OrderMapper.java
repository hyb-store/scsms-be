package com.scsms.mapper;

import com.scsms.pojo.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    public List<Order> getBuyOrder(Integer saleCarId);

    public List<Order> getSaleOrder(Integer saleCarId);
}
