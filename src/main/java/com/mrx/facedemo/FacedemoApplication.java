package com.mrx.facedemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.mrx.facedemo.dao")
public class FacedemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FacedemoApplication.class, args);
    }

}
