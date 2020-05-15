package com.cloud.controller;

import com.cloud.entites.CommonResult;
import com.cloud.entites.Payment;
import com.cloud.serivce.PayMentSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class PayMentController {

    @Autowired
    private PayMentSerivce payMentSerivce;

    @Value("${server.port}")
    private Integer port;

    @PostMapping("/payment")
    public CommonResult insertPayMent(@RequestBody Payment payment){
        int result=payMentSerivce.insertPayMent(payment);
        CommonResult<Payment> commonResult=null;
        if(result>0){
            commonResult = new CommonResult<Payment>(200, "插入成功", payment);
        }else{
            commonResult = new CommonResult<Payment>(500, "插入失败");
        }
        return commonResult;
    };

    @GetMapping("/payment/get/{id}")
    public CommonResult queryPayMentForId(@PathVariable("id") long id){
        Payment payment = payMentSerivce.queryPayMentForId(id);
        CommonResult<Payment> commonResult=null;
        if(payment!=null){
            commonResult = new CommonResult<Payment>(200, "查询成功port:"+port, payment);
        }else{
            commonResult = new CommonResult<Payment>(200, "记录不存在id:"+id);
        }
        System.out.println("--------**********************---"+commonResult);
        return commonResult;
    };

    @GetMapping("/payment/port")
    public String getPort(){
        return port.toString();
    };

    @GetMapping("/payment/timeout")
    public String timeout(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "gogogo";
    };



}
