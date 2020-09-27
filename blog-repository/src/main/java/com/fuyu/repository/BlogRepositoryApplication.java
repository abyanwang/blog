package com.fuyu.repository;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fuyu.repository.mybatis.mapper")
public class BlogRepositoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogRepositoryApplication.class);
    }
}
