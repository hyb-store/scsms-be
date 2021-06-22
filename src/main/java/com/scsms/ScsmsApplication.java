package com.scsms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.scsms.mapper")
@SpringBootApplication
public class ScsmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScsmsApplication.class, args);
    }

}
