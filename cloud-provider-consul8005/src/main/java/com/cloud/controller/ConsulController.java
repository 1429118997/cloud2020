package com.cloud.controller;

import com.cloud.entites.CommonResult;
import com.cloud.entites.Payment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ConsulController {
    @GetMapping("/payment/consul")
    public CommonResult paymentConsul(){
        CommonResult<Payment> commonResult=commonResult = new CommonResult<Payment>(200, "open consul register UUID:"+ UUID.randomUUID());
        return commonResult;
    };
}
