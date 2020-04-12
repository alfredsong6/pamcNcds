package com.pamc.ncds.schedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in 2020/3/28 18:32
 * @Modified :
 **/
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableFeignClients(basePackages = {"com.pamc.ncds.bi.cleint","com.pamc.ncds.message.api"})
@EnableEurekaClient
public class ScheduleApp {
    public static void main(String[] args) {
        SpringApplication.run(ScheduleApp.class,args);
    }
}
