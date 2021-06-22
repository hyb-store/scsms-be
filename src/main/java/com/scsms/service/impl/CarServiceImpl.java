package com.scsms.service.impl;

import com.scsms.mapper.CarMapper;
import com.scsms.pojo.SaleCar;
import com.scsms.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarMapper carMapper;

    @Override
    public List<SaleCar> selectAll() {
        return carMapper.selectAll();
    }
}
