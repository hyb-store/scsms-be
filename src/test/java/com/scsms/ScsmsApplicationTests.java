package com.scsms;

import com.github.pagehelper.PageInfo;
import com.scsms.pojo.SaleCar;
import com.scsms.service.CarService;

import com.scsms.service.SaleCarService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ScsmsApplicationTests {

    @Autowired
    private SaleCarService saleCarService;

    @Test
    void contextLoads() {
        PageInfo<SaleCar> res = saleCarService.selectList(1, 20, "奥迪", "", null);
        List<SaleCar> list = res.getList();
        for (SaleCar saleCar : list) {
            System.out.println(saleCar);
        }
    }

}
