package com.atguigu.springcloud.springcloud.com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yswu
 * @date 2021-02-19 21:39
 */

@Configuration
public class MySelfRule {

    @Bean
    public IRule myrule(){
        return new RandomRule();
    }
}
