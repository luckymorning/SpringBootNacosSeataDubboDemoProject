package com.cn.lucky.morning.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan("com.cn.lucky.morning.order.mapper")
@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceOrderApplication.class, args);
    }

}
