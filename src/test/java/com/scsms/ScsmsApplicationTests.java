package com.scsms;

import com.scsms.service.CarService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ScsmsApplicationTests {

    @Autowired
    private CarService carService;

    @Test
    void contextLoads() {

    }

}
