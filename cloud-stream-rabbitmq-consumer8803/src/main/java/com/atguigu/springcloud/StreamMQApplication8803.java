package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author yswu
 * @date 2021-02-25 22:01
 */

@SpringBootApplication
@EnableEurekaClient
public class StreamMQApplication8803 {

    public static void main(String[] args) {
        SpringApplication.run(StreamMQApplication8803.class,args);
    }

}
