package com.atguigu.springcloud.springcloud.springcloud.controller;

import com.atguigu.springcloud.springcloud.springcloud.entities.CommonResult;
import com.atguigu.springcloud.springcloud.springcloud.entities.Payment;
import com.atguigu.springcloud.springcloud.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author yswu
 * @date 2021-02-06 10:03
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;


    @Autowired
    private DiscoveryClient discoveryClient;


    @PostMapping(value="/payment/create")
    public CommonResult create(@RequestBody Payment payment){

        int result = paymentService.create(payment);

        log.info("**插入结果：" + result);

        if(result>0){
            return new CommonResult(200,"插入数据库成功,serverPort:" +serverPort,payment);
        }else{
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    @GetMapping(value="/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);


        log.info("**查询结果：" + payment + "哈哈哈 哈喽");

        if(payment!=null){
            return new CommonResult(200,"查询数据库成功,serverPort:" +serverPort,payment);
        }else{
            return new CommonResult(444,"没有这条记录，ID:"+id,null);
        }
    }


    @GetMapping(value="/payment/discovery")
    public Object discovery(){

        //有哪几个微服务
        List<String> services = discoveryClient.getServices();
        for(String element:services){
            log.info("***element:"+element);
        }

        //一个微服务下的全部实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for(ServiceInstance instance:instances){
            log.info(instance.getInstanceId()+"\t"+instance.getHost()+"\t"+instance.getUri());
        }

        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }


    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try{
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        return serverPort;

    }
}
