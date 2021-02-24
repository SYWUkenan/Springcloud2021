package com.atguigu.springcloud.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author yswu
 * @date 2021-02-21 13:20
 */
@Component
public class PaymentHystrixServiceFallBack implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfoOk ,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfoTimeOut(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfoTimeOut ,o(╥﹏╥)o";
    }
}
