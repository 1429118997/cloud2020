package com.cloud.LB;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLRule implements LoadBalancer{

    private AtomicInteger count=new AtomicInteger(0);

    @Override
    public ServiceInstance instance(List<ServiceInstance> list) {
        int index=incrementAndGetModulo()%list.size();
        return list.get(index);
    }

    public final int incrementAndGetModulo(){
        int current,next;
       do{
           current = count.get();
           next=current>=Integer.MAX_VALUE?0:current+1;
       }while (!count.compareAndSet(current,next));
       System.out.println(next);
       return next;
    }

}
