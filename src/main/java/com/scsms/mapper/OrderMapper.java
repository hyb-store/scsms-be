package com.scsms.mapper;

import com.scsms.pojo.Order;
import org.apache.ibatis.annotations.Mapper;

import javax.servlet.http.HttpSession;

@Mapper
public interface OrderMapper {

    public Order getOrder(Integer saleCarId);
}
