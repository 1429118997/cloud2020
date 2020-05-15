package com.cloud.controller;

import com.cloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@DefaultProperties(defaultFallback = "payment_timeout_hander",commandProperties = {
        @HystrixProperty(
                name = "execution.isolation.thread.timeoutInMilliseconds",
                value = "4000"
        )
})

public class HystrixOrderController {


    @Resource
    private PaymentService paymentService;


    @GetMapping("/consumer/payment/ok")
    @HystrixCommand
    public String payment_ok() {
        return paymentService.payment_ok();
    }

//    @HystrixCommand(fallbackMethod ="payment_timeout_hander",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "4000")
//    })
    @GetMapping("/consumer/payment/timeout/{id}")
    @HystrixCommand
    public String payment_timeout(@PathVariable("id") int id) {
        return paymentService.payment_timeout(id);
    }


    public String payment_timeout_hander(){
        return "(┬＿┬)————————————————";
    }
}
