package com.pamc.ncds.message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in 2020/3/28 23:15
 * @Modified :
 **/
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
public class MessageApp {
    public static void main(String[] args) {
        SpringApplication.run(MessageApp.class,args);
    }
}
