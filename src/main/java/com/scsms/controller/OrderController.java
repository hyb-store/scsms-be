package com.scsms.controller;

import com.scsms.pojo.Order;
import com.scsms.response.ResponseData;
import com.scsms.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/getorder")//查找该用户对应的sale_car信息
    public ResponseData getOrder(@RequestParam(value = "userId") Integer id){
        ResponseData responseData = null;
        if (id == null) {
            return new ResponseData(1, "参数为空，查询失败", null);
        }

        Map<String, List<Order>> order = orderService.getOrder(id);
        if (order == null || order.size() == 0) {
            responseData = new ResponseData(1, "没有记录", null);
        } else {
            responseData = new ResponseData(0, "参数成功", order);
        }
        return responseData;
    }
}
