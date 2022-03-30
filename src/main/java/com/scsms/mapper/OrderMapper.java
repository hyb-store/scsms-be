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

    public void insertOrder(@Param("id") Integer id, @Param("userId")Integer userId, @Param("buyerId")Integer buyerId, @Param("price")Integer price, @Param("buyTime")Date buyTime);
}
