package com.scsms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scsms.mapper.SaleCarMapper;
import com.scsms.pojo.SaleCar;
import com.scsms.service.SaleCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    @Override
    public SaleCar insertOne(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        SaleCar saleCar = createBean(map);

        saleCarMapper.insert(saleCar);

        return saleCar;
    }

    @Override
    public SaleCar selectOne(Integer id) {
        return saleCarMapper.selectOne(id);
    }

    @Override
    public PageInfo<SaleCar> query(int page, int size,String query) {
        PageHelper.startPage(page, size);
        System.out.println(query);
        List<SaleCar> saleCarQuery = saleCarMapper.query(query);
        return new PageInfo<>(saleCarQuery);
    }

    @Override
    public void delete(int id) {
        saleCarMapper.delete(id);
    }

    private SaleCar createBean(Map<String, String> map) {
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        SaleCar saleCar = new SaleCar();
        //封装car_id
        int carId = saleCarMapper.selectCarId(map.get("brand"), map.get("series"), map.get("model"));
        saleCar.setCarId(carId);
        //封装user_id
        saleCar.setUserId(Integer.parseInt(map.get("userId")));
        //设置浏览量，初始为0
        saleCar.setViews(0);
        //行驶里程  km
        saleCar.setKm(Integer.parseInt(map.get("km")));
        //价格 price
        saleCar.setPrice(Integer.parseInt(map.get("price")));
        //购买时间
        DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
        Date buyTime = null;
        try {
            buyTime = fmt.parse(map.get("buyTime"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        saleCar.setBuyTime(buyTime);
        //创建时间
        saleCar.setCreateTime(new Date());
        return saleCar;
    }
}
