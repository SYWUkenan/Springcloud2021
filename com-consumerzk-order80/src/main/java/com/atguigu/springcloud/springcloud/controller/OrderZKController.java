package com.atguigu.springcloud.springcloud.controller;

import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author yswu
 * @date 2021-02-19 09:53
 */

@RestController
@Slf4j
@RequestMapping(value = "/consumer")
public class OrderZKController {

    private static final String INVOKE_URL="http://cloud-provider-payment";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value = "/payment/zk")
    public String paymentInfo(){


        String result = restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);

        return result;
    }


}
