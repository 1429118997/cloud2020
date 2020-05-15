package com.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cloud.entites.CommonResult;
import com.cloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class CircuitBreakerController {

    @Autowired
    public RestTemplate restTemplate;

    public final static String server_uri="http://cloud-alibaba-provider-payment/";

    @GetMapping("/payment/fallback/{id}")
    @SentinelResource(value = "fallback",fallback = "fallback_handler",exceptionsToIgnore = IllegalArgumentException.class)
//    @SentinelResource(value = "fallback",blockHandler = "block_handler")
//    @SentinelResource(value = "fallback",blockHandler = "block_handler",fallback = "fallback_handler")
    public CommonResult fallback(@PathVariable("id") String id){
        CommonResult result = restTemplate.getForObject(server_uri + "payment/" + id, CommonResult.class);

        if (id.equals("4")){
            throw new IllegalArgumentException("淦，别乱丢参数");
        }else if(Integer.parseInt(id)>4){
            throw new NullPointerException("没有大于4的id");
        }
        return  result;
    }

    public CommonResult fallback_handler(@PathVariable("id") String id,Throwable throwable){
        CommonResult result =new CommonResult(444,throwable.getMessage());
        return result;
    }

    public CommonResult block_handler( String id, BlockException e){
        CommonResult result =new CommonResult(444,"flow_limit");
        return result;
    }


    //----------------------------------------------------------------------------------

    @Resource
    public PaymentService paymentService;

    @GetMapping("/payment/qry/{id}")
    public CommonResult method(@PathVariable("id") String id){
        CommonResult result = paymentService.queryPayMentForId(id);
        if (id.equals("4")){
            throw new IllegalArgumentException("淦，别乱丢参数");
        }else if(Integer.parseInt(id)>4){
            throw new NullPointerException("没有大于4的id");
        }
        return  result;
    }

}
