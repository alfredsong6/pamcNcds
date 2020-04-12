package com.pamc.test.model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in 2020/4/11 18:14
 * @Modified :
 **/
@SpringBootApplication
@EnableEurekaClient
public class TestApp {
    public static void main(String[] args) {
        SpringApplication.run(TestApp.class,args);
    }
}
