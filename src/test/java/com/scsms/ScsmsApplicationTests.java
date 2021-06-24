package com.scsms;

import com.scsms.mapper.SaleCarMapper;

import com.scsms.pojo.SaleCar;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ScsmsApplicationTests {

    @Autowired
    private SaleCarMapper saleCarMapper;

    @Test
    void contextLoads() {
        SaleCar saleCar = saleCarMapper.selectOne(1);
        System.out.println(saleCar);
    }

}
