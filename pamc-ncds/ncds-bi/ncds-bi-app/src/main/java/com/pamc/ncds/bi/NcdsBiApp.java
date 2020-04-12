package com.pamc.ncds.bi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in 2020/3/28 9:13
 * @Modified :
 **/
@SpringBootApplication
@EnableCaching
@EnableEurekaClient
public class NcdsBiApp {
    public static void main(String[] args) {
        SpringApplication.run(NcdsBiApp.class,args);
    }
}
