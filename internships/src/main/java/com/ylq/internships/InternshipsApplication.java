package com.ylq.internships;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.ylq.internships.mapper")
@SpringBootApplication
public class InternshipsApplication {

    public static void main(String[] args) {
        SpringApplication.run(InternshipsApplication.class, args);
    }

}
