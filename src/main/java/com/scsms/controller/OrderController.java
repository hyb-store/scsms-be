package com.scsms.controller;

import com.scsms.response.ResponseData;
import com.scsms.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/getorder")//查找该用户对应的salecar信息
    public ResponseData getOrder(@RequestParam(value = "userId") Integer id){
        ResponseData responseData = null;
        if (id == null) {
            return new ResponseData(1, "参数为空，查询失败", null);
        }
        orderService.getOrder(id);


        return new ResponseData(0, "查询成功", null);
    }
}
