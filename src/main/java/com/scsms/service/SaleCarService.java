package com.scsms.service;

import com.github.pagehelper.PageInfo;
import com.scsms.pojo.SaleCar;

import java.util.List;

public interface SaleCarService {

    PageInfo<SaleCar> selectList(int page, int size, String brand, String series, String price);
}
