package com.scsms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scsms.mapper.SaleCarMapper;
import com.scsms.pojo.SaleCar;
import com.scsms.pojo.User;
import com.scsms.service.SaleCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
    public SaleCar insertOne(Map<String, String> map, HttpSession session) {
        if (map == null) {
            return null;
        }
        SaleCar saleCar = createBean(map, session);

        saleCarMapper.insert(saleCar);

        return saleCar;
    }

    @Override
    public SaleCar selectOne(Integer id) {
        return saleCarMapper.selectOne(id);
    }

    private SaleCar createBean(Map<String, String> map, HttpSession session) {
        SaleCar saleCar = new SaleCar();
        //封装car_id
        int carId = saleCarMapper.selectCarId(map.get("brand"), map.get("series"), map.get("model"));
        saleCar.setCarId(carId);
        //买车时间 buyTime
        saleCar.setCreateTime(new Date(Long.parseLong(map.get("buyTime"))));
        //封装店铺id
        saleCar.setStoreId(1);
        //封装user_id
        User user = (User) session.getAttribute("user");
        saleCar.setUserId(user.getId());
        //设置浏览量，初始为0
        saleCar.setViews(0);
        //设置状态,默认为0
        saleCar.setStatus(0);
        //行驶里程  km
        saleCar.setKm(Integer.parseInt(map.get("km")));
        //颜色 color
        saleCar.setColor(map.get("color"));
        //价格 price
        saleCar.setPrice(Integer.parseInt(map.get("prices")));
        //创建时间
        saleCar.setCreateTime(new Date());

        return saleCar;
    }
}
