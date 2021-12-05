package com.example.newtest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com/example/newtest/mapper")
public class NewTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(NewTestApplication.class, args);
    }

}
