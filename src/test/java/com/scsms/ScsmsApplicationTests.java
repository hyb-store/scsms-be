package com.scsms;

import com.github.pagehelper.PageInfo;
import com.scsms.mapper.SaleCarMapper;

import com.scsms.pojo.SaleCar;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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

    @Test
    void contextLoads1() {
        List<SaleCar> saleCar = saleCarMapper.query("奥迪");
        System.out.println(saleCar);
    }

    @Test
    void contextLoads2() {
        List<Integer> goods = new ArrayList<>();
        goods.add(2);
        goods.add(100);
        goods.add(2);
        goods.add(3);
        goods.add(3);
        goods.add(90);
        goods.add(3);
        goods.add(2);
        goods.add(80);
        goods.add(2);

            int[] dp = new int[goods.size()];//动态数组
            dp[0] = goods.get(0);
            dp[1] = goods.get(1);
            for(int i = 3; i < goods.size();i++) {
                dp[i] = Math.min(dp[i - 2] + goods.get(i), dp[i - 1] + goods.get(i));
            }
        System.out.println(Math.min(dp[goods.size() - 1], dp[goods.size() - 2]));
    }

}
