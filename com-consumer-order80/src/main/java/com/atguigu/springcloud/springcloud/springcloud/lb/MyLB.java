package com.atguigu.springcloud.springcloud.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yswu
 * @date 2021-02-20 10:11
 */

@Component
public class MyLB implements LoadBalancer {


    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;
        do{
            current = this.atomicInteger.get();
            next = current>2147383647 ? 0 :current + 1;

        }while(!this.atomicInteger.compareAndSet(current,next));
        System.out.println("*****请求的第几次next： "+ next);

        return next;
    }



    @Override
    public ServiceInstance Instance(List<ServiceInstance> serviceInstances) {

        int index = getAndIncrement() % serviceInstances.size();


        return serviceInstances.get(index);
    }
}
