package com.cloud.controller;

import com.cloud.entites.CommonResult;
import com.cloud.entites.Payment;
import com.cloud.serivce.PayMentSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ZookeeperController {

    @Autowired
    private PayMentSerivce payMentSerivce;

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/payment/{id}")
    public CommonResult queryPayMentForId(@PathVariable("id") long id){
        Payment payment = payMentSerivce.queryPayMentForId(id);
        CommonResult<Payment> commonResult=null;
        if(payment!=null){
            commonResult = new CommonResult<Payment>(200, "查询成功port:"+port+"\tuuid:"+ UUID.randomUUID(), payment);
        }else{
            commonResult = new CommonResult<Payment>(200, "记录不存在id:"+id);
        }
        System.out.println("--------**********************---"+commonResult);
        return commonResult;
    };
}
