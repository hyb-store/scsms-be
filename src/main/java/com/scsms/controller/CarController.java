package com.scsms.controller;

import com.scsms.pojo.SaleCar;
import com.scsms.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/selectAll")
    public List<SaleCar> selectAll() {
        return carService.selectAll();
    }
}
