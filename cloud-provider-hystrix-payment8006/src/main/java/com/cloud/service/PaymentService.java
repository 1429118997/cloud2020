package com.cloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


/*
 *测试用，一帮都是面向接口的
*/
@Service
public class PaymentService {

    public String payment_ok(int id){
        System.out.println(Thread.currentThread().getName()+"\t"+"______OK");
        return Thread.currentThread().getName()+"\t"+"______OK";
    }


    @HystrixCommand(fallbackMethod ="payment_timeout_hander",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "6000")
    })
    public String payment_timeout(int id){
        int seconds=3;
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"\t"+"______timeout   wait(s):"+seconds+"\tid:"+id);
        return Thread.currentThread().getName()+"\t"+"______timeout   wait(s):"+seconds+"\tid:"+id;
    }


    public String payment_timeout_hander(int id){
        return "(┬＿┬)\tid:";
    }


    @HystrixCommand(fallbackMethod = "payment_circuit_handler",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "100000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")
    })
    public String payment_circuit(int id){
        if (id<0){
            throw new RuntimeException();
        }else{
            String uuid = IdUtil.simpleUUID();
            return "———_————\tid:"+id+"\tuuid:"+uuid;
        }
    }

    public String payment_circuit_handler(int id){
        String s = IdUtil.simpleUUID();
        return "（————————）uuid:"+s+"\tid:"+id;
    }
}
