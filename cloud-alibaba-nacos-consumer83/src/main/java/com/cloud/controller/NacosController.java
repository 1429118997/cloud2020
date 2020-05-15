package com.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class NacosController {

    @Autowired
    public RestTemplate restTemplate;

    public final static String server_uri="http://nacos-payment-provider";

    @GetMapping("/consumer/payment/port")
    public String test(){
        return restTemplate.getForObject(server_uri+"/payment/port", String.class);
    }
}
