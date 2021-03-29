package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yswu
 * @date 2021-03-29 13:40
 */
@EnableDiscoveryClient
@SpringBootApplication
public class serviceApplication8401 {
    public static void main(String[] args) {
        SpringApplication.run(serviceApplication8401.class,args);
    }
}
