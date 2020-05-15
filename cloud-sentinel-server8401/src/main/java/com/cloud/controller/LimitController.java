package com.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cloud.handler.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitController {


    @GetMapping("/resource")
    @SentinelResource(value = "resource",blockHandler = "resource_handler")
    public String resource(){
        return "resource";
    }


    public String resource_handler(BlockException e){
        return "resource_handler";
    }

    @GetMapping("/url")
    @SentinelResource(value = "url")
    public String url(String p1,String p2){
        return "url";
    }


    @GetMapping("/excp")
    @SentinelResource(value = "excp",blockHandlerClass = ExceptionHandler.class,blockHandler = "exceptionhandler")
    public String exceptionClass(){
        return "exceptionClass";
    }


}
