package com.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SentinelController {

    @Autowired
    public RestTemplate restTemplate;

    @GetMapping("/testA")
    public String testA(){
        return restTemplate.getForObject("http://cloud-sentienl-server/testC", String.class);
    }
    @GetMapping("/testB")
    public String testB(){
        return restTemplate.getForObject("http://cloud-sentienl-server/testC", String.class);
    }

    @GetMapping("/testC")
    public String testC(){
        int i=10/0;
        return "testC";
    }


    @GetMapping("/hotkey")
    @SentinelResource(value = "hotkey",blockHandler = "hotkey_handler")
    public String hotkey(String p1,String p2){
        int i=10/0;
        return "ok p1"+p1+"\tp2"+p2;
    }

    public String hotkey_handler(String p1, String p2, BlockException e){
        return "bad p1"+p1+"\tp2"+p2;
    }
}
