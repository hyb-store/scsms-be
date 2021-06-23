package com.scsms;

import com.scsms.mapper.CarMapper;
import com.scsms.mapper.SaleCarMapper;
import com.scsms.pojo.Car;
import com.scsms.pojo.SaleCar;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ScsmsApplicationTests {

    @Autowired
    private SaleCarMapper saleCar;

    @Test
    void contextLoads() {
        List<SaleCar> cars = saleCar.selectList(null, null, 30000, 80000);

        for (SaleCar car : cars) {
            System.out.println(car);
        }
    }

}
