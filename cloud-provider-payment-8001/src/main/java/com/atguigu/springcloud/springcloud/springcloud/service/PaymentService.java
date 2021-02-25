package com.atguigu.springcloud.springcloud.springcloud.service;

import com.atguigu.springcloud.springcloud.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author yswu
 * @date 2021-02-06 10:00
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
