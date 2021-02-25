package com.atguigu.springcloud.springcloud.springcloud.service.impl;

import com.atguigu.springcloud.springcloud.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.springcloud.springcloud.entities.Payment;
import com.atguigu.springcloud.springcloud.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yswu
 * @date 2021-02-06 10:00
 */

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
