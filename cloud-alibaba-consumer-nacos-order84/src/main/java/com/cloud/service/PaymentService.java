package com.cloud.service;

import com.cloud.entites.CommonResult;
import com.cloud.service.impl.PaymentServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "cloud-alibaba-provider-payment",fallback = PaymentServiceImpl.class)
public interface PaymentService {
    @GetMapping("/payment/{id}")
    public CommonResult queryPayMentForId(@PathVariable("id") String id);
}
