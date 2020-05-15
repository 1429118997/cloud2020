package com.cloud.controller;


import com.cloud.entites.CommonResult;
import com.cloud.service.ProviderSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    ProviderSerivce providerSerivce;

    @GetMapping("/consumer/payment/{id}")
    public CommonResult create(@PathVariable("id") long id){
        return providerSerivce.test(id);
    }

    @GetMapping("/consumer/payment/timeout")
    public String timeout(){
        return providerSerivce.timeout();
    }
}
