package com.cloud.service;

import com.cloud.entites.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("CLOUD-PROVIDER-SERVICE")
public interface ProviderSerivce {


    @GetMapping("/payment/get/{id}")
    public CommonResult test(@PathVariable("id") long id);

    @GetMapping("/payment/timeout")
    public String timeout();
}
