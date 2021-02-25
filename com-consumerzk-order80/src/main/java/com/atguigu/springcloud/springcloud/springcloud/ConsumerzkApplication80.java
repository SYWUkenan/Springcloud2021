package com.atguigu.springcloud.springcloud.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yswu
 * @date 2021-02-19 09:42
 */

@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerzkApplication80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerzkApplication80.class,args);

    }
}
