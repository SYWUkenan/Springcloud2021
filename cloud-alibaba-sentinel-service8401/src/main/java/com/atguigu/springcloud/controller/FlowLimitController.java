package com.atguigu.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yswu
 * @date 2021-03-29 13:42
 */
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String TestA(){
        return "----testA";
    }
    @GetMapping("/testB")
    public String TestB(){
        return "----testB";
    }
}
