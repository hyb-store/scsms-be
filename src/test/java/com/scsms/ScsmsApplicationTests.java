package com.scsms;

import com.scsms.mapper.SaleCarMapper;

import com.scsms.pojo.SaleCar;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@SpringBootTest
class ScsmsApplicationTests {

    @Autowired
    private SaleCarMapper saleCarMapper;

    @Test
    void contextLoads() {
        SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd");

        try {
            System.out.println(sfd.parse("2021-06-24"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
