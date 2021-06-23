package com.scsms.controller;

import com.scsms.response.ResponseData;
import com.scsms.service.SaleCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("/sale")
public class SaleController {

    @Autowired
    private SaleCarService saleCarService;

    @PostMapping("/index")
    public ResponseData saleCar(@RequestBody Map<String, String> map, HttpSession session) {
        ResponseData responseData = null;

        saleCarService.insertOne(map,session);

        return null;
    }


}
