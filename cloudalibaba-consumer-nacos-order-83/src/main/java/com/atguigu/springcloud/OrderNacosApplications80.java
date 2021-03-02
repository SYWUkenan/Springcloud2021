package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yswu
 * @date 2021-03-02 22:18
 */

@SpringBootApplication
@EnableDiscoveryClient

public class OrderNacosApplications80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderNacosApplications80.class,args);
    }

}
