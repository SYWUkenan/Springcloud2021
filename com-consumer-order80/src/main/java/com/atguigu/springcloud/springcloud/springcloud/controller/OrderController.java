package com.atguigu.springcloud.springcloud.springcloud.controller;


import com.atguigu.springcloud.springcloud.springcloud.entities.CommonResult;
import com.atguigu.springcloud.springcloud.springcloud.entities.Payment;
import com.atguigu.springcloud.springcloud.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author yswu
 * @date 2021-02-06 13:49
 */

@RestController
@Slf4j
public class OrderController {

        private static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";
        @Resource
        private RestTemplate restTemplate;

        @Autowired
        private LoadBalancer loadBalancer;

        @Autowired
        DiscoveryClient discoveryClient;


        @GetMapping("/consumer/payment/create")
        public CommonResult<Payment> create(Payment payment){
                return restTemplate.postForObject(PAYMENT_URL+"/payment/create"
                , payment,CommonResult.class);
        }


        @GetMapping("/consumer/payment/get/{id}")
        public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
                log.info("**consumer查询结果" + id);
                return restTemplate.getForObject(PAYMENT_URL+"/payment/get/" + id,CommonResult.class);


        }

        @GetMapping("/consumer/payment/getForEntity/{id}")
        public CommonResult<Payment> getPayment2(@PathVariable("id") Long id){
                log.info("**consumer查询结果" + id);
                ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
                if(entity.getStatusCode().is2xxSuccessful()){
                        return entity.getBody();
                }else{
                        return new CommonResult<>(444,"操作失败");
                }

        }


        @GetMapping(value = "/consumer/payment/lb")
        public String getPaymentLB(){

                List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
                if(instances == null || instances.size()<0){
                        return null;
                }

                ServiceInstance instance = loadBalancer.Instance(instances);
                URI uri = instance.getUri();
                return restTemplate.getForObject(uri+"payment/lb",String.class);


        }


}
