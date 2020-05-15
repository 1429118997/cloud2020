package com.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosController {

    @Value("${server.port}")
    private String port;


    @GetMapping("/payment/port")
    public String test(){
        return "nacos port:"+port;
    }
}
