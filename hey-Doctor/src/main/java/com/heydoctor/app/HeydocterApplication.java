package com.heydoctor.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HeydocterApplication {
    public static void main(String[] args) {
        SpringApplication.run(HeydocterApplication.class, args);
    }

}
