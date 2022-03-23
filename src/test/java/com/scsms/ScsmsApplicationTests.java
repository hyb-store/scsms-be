package com.scsms;

import com.scsms.mapper.CarMapper;
import com.scsms.mapper.SaleCarMapper;

import com.scsms.pojo.SaleCar;
import com.scsms.service.CarService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SpringBootTest
class ScsmsApplicationTests {

    @Autowired
    private CarService carService;

    @Test
    void contextLoads() {
        Map<String, List<String>> stringListMap = carService.selectList();

        Set<Map.Entry<String, List<String>>> entries = stringListMap.entrySet();
        for (Map.Entry<String, List<String>> entry : entries) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

    }

}
