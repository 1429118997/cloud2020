package com.cloud.controller;

import com.cloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @Autowired
    public PaymentService paymentService;


    @GetMapping("/payment/ok")
    public String payment_ok(){
        return  paymentService.payment_ok(100);
    }

    @GetMapping("/payment/timeout/{id}")
    public String payment_timeout(@PathVariable("id")int id){
        return paymentService.payment_timeout(id);
    }

    @GetMapping("/payment/circuit/{id}")
    public String payment_circuit(@PathVariable("id") int id){
        return  paymentService.payment_circuit(id);
    }

}
