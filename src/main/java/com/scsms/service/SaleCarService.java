package com.scsms.service;

import com.github.pagehelper.PageInfo;
import com.scsms.pojo.SaleCar;
import java.util.Map;

public interface SaleCarService {

    PageInfo<SaleCar> selectList(int page, int size, String brand, String series, String price);

    SaleCar insertOne(Map<String, String> map);

    SaleCar selectOne(Integer id);

    PageInfo<SaleCar> query(int page, int size, String query);

    void delete(int id);

}
