package com.scsms.service;

import com.scsms.pojo.Car;

import java.util.List;
import java.util.Map;

public interface CarService {

    Map<String, List<String>> selectList();

    List<String> selectBrandList();

    List<String> selectSeriesLimitByBrand(String brand);

    List<String> selectSeriesListByBrand(String brand);
}
