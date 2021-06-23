package com.scsms.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scsms.mapper.SaleCarMapper;
import com.scsms.pojo.SaleCar;
import com.scsms.service.SaleCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleCarServiceImpl implements SaleCarService {

    @Autowired
    private SaleCarMapper saleCarMapper;

    @Override
    public PageInfo<SaleCar> selectList(int page, int size, String brand, String series, String price) {
        int lowPrice = 0;
        int highPrice = 9999999;
        if (price != null) {
            String[] p = price.split("-");
            lowPrice = Integer.parseInt(p[0]);
            highPrice = Integer.parseInt(p[1]);
        }
        PageHelper.startPage(page, size);

        List<SaleCar> saleCars = saleCarMapper.selectList(brand, series, lowPrice, highPrice);

        return new PageInfo<>(saleCars);
    }
}
