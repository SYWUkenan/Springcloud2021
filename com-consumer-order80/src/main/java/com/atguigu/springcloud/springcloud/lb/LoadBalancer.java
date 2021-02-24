package com.atguigu.springcloud.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author yswu
 * @date 2021-02-20 10:09
 */
public interface LoadBalancer {

    ServiceInstance Instance(List<ServiceInstance> serviceInstances);
}
