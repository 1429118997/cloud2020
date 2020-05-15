package com.cloud.service;


import com.cloud.service.impl.PaymentServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentServiceImpl.class)
public interface PaymentService {

    @GetMapping("/payment/ok")
    public String payment_ok();

    @GetMapping("/payment/timeout/{id}")
    public String payment_timeout(@PathVariable("id") int id);
}
