package com.scsms.mapper;

import com.scsms.pojo.Order;
import com.scsms.pojo.SaleCar;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface OrderMapper {

    public List<Order> getBuyOrder(Integer saleCarId);

    public List<Order> getSaleOrder(Integer saleCarId);

    public void insertOrder(SaleCar saleCar, Integer buyerId, Date buyTime);
}
