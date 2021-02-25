package com.atguigu.springcloud.springcloud.springcloud.dao;

import com.atguigu.springcloud.springcloud.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author yswu
 * @date 2021-02-06 09:45
 */
@Mapper
public interface PaymentDao {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

}
