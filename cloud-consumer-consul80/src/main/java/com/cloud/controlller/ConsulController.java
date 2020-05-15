package com.cloud.controlller;

import com.cloud.entites.CommonResult;
import com.cloud.entites.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RestController
public class ConsulController {

    @Autowired
    private RestTemplate restTemplate;

    private static String PROVIDER_URL="http://cloud-provider-payment/";

    @GetMapping("/consumer/payment")
    public CommonResult create(){
        return restTemplate.getForObject(PROVIDER_URL+"payment/consul" ,CommonResult.class );
    }
}
