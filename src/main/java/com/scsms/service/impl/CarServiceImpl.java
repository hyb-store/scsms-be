package com.scsms.service.impl;

import com.scsms.mapper.CarMapper;
import com.scsms.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarMapper carMapper;

    @Override
    public Map<String, List<String>> selectList() {
        List<String> brands = carMapper.selectBrandLimit();
        List<String> series = carMapper.selectSeriesLimit();

        Map<String, List<String>> map = new HashMap<>();

        map.put("brands", brands);
        map.put("series", series);

        return map;
    }

    @Override
    public List<String> selectBrandList() {
        return carMapper.selectBrandList();
    }

    @Override
    public List<String> selectSeriesLimit(String brand) {
        return carMapper.selectSeriesLimitByBrand(brand);
    }

    @Override
    public List<String> selectModelList(String series) {
        return carMapper.selectModelList(series);
    }

    @Override
    public List<String> selectSeriesList(String brand) {
        List<String> brands = carMapper.selectSeriesList(brand);
        return brands;
    }
}
