package com.scsms.controller;

import com.github.pagehelper.PageInfo;
import com.scsms.pojo.SaleCar;
import com.scsms.response.ResponseData;
import com.scsms.service.CarService;
import com.scsms.service.SaleCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/buy")
public class BuyController {

    @Autowired
    private CarService carService;

    @Autowired
    private SaleCarService saleCarService;

    @GetMapping("/index")
    public ResponseData getCarInfo() {
        Map<String, List<String >> map = carService.selectList();
        ResponseData responseData = null;
        if (map != null) {
            responseData = new ResponseData(0, "查询成功", map);
        } else {
            responseData = new ResponseData(1, "查询失败", null);
        }

        return responseData;
    }

    @GetMapping("/brands")//全部品牌
    public ResponseData selectBrandList() {
        List<String> brands = carService.selectBrandList();
        ResponseData responseData = null;
        if (brands != null) {
            responseData = new ResponseData(0, "查询成功", brands);
        } else {
            responseData = new ResponseData(1, "查询失败", null);
        }
        return responseData;
    }

    @GetMapping("/seriesLimit") //根据品牌查车系 10
    public ResponseData selectSeriesLimitByBrand(@RequestParam(value = "brand") String brand) {
        ResponseData responseData = null;
        if (brand == null || brand.equals("")) {
            return new ResponseData(1, "查询条件为空", null);
        }
        List<String> series = carService.selectSeriesLimitByBrand(brand);
        if (series != null) {
            responseData = new ResponseData(0, "查询成功", series);
        } else {
            responseData = new ResponseData(1, "查询失败", null);
        }
        return responseData;
    }

    @GetMapping("/series")//根据品牌查全部车系
    public ResponseData selectSeriesListByBrand(@RequestParam(value = "brand") String brand) {
        ResponseData responseData = null;
        if (brand == null || brand.equals("")) {
            return new ResponseData(1, "查询条件为空", null);
        }
        List<String> series = carService.selectSeriesListByBrand(brand);
        if (series != null) {
            responseData = new ResponseData(0, "查询成功", series);
        } else {
            responseData = new ResponseData(1, "查询失败", null);
        }
        return responseData;
    }

    @GetMapping("/queryInfo")
    public ResponseData selectCarInfo(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                                      @RequestParam(name = "size", required = true, defaultValue = "5") Integer size,
                                      @RequestParam(value = "brand", required =  false) String brand,
                                      @RequestParam(value = "series", required = false) String series,
                                      @RequestParam(value = "price", required = false) String price) {

        ResponseData responseData = null;
        PageInfo<SaleCar> saleCarPageInfo = saleCarService.selectList(page, size, brand, series, price);
        if (saleCarPageInfo != null) {
            responseData = new ResponseData(0, "success", saleCarPageInfo);
        } else {
            responseData = new ResponseData(1, "fail", null);
        }

        return responseData;
    }


}
