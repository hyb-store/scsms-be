package com.scsms.controller;

import com.scsms.pojo.Order;
import com.scsms.pojo.SaleCar;
import com.scsms.response.ResponseData;
import com.scsms.service.OrderService;
import com.scsms.service.SaleCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/order")
public class OrderController {

    class InsertParam {
        private Integer saleCarId;
        private Integer buyerId;

        public InsertParam(Integer saleCarId, Integer buyerId) {
            this.saleCarId = saleCarId;
            this.buyerId = buyerId;
        }

        public Integer getSaleCarId() {
            return saleCarId;
        }

        public void setSaleCarId(Integer saleCarId) {
            this.saleCarId = saleCarId;
        }

        public Integer getBuyerId() {
            return buyerId;
        }

        public void setBuyerId(Integer buyerId) {
            this.buyerId = buyerId;
        }
    }

    @Autowired
    private OrderService orderService;

    @Autowired
    private SaleCarService saleCarService;

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

    @PostMapping("/insert")//插入订单，交易完成
    public ResponseData insertOrder(@RequestBody InsertParam insertParam){
        ResponseData responseData = null;
        Integer saleCarId = insertParam.getSaleCarId();
        Integer buyerId = insertParam.getBuyerId();

        if (saleCarId == null || buyerId == null) {
            return new ResponseData(1, "参数为空，插入失败", null);
        }

        SaleCar saleCar = saleCarService.selectOne(saleCarId);

        orderService.insertOrder(saleCar, buyerId);
        responseData = new ResponseData(0, "插入成功", null);

        saleCarService.delete(saleCarId);

        return responseData;
    }
}
