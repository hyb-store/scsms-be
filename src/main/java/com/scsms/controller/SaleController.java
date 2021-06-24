package com.scsms.controller;

import com.scsms.pojo.SaleCar;
import com.scsms.response.ResponseData;
import com.scsms.service.SaleCarService;
import com.scsms.util.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/sale")
public class SaleController {

    @Autowired
    private SaleCarService saleCarService;

    @PostMapping("/index")
    public ResponseData saleCar(@RequestBody Map<String, String> map) {
        ResponseData responseData = null;
        if (map == null) {
            responseData = new ResponseData(0, "字段为空", null);
        }
        ArrayList<String> list;
        if ((list = MapUtils.getNullKey(map)).size() != 0) {
            responseData = new ResponseData(0, "data中的字段值为空", list);
        }

        SaleCar saleCar = saleCarService.insertOne(map);

        if (saleCar != null) {
            responseData = new ResponseData(0, "success", saleCar);
        } else {
            responseData = new ResponseData(1, "fail", null);
        }

        return responseData;
    }


}
