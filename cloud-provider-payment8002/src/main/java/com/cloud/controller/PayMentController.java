package com.cloud.controller;

import com.cloud.entites.CommonResult;
import com.cloud.entites.Payment;
import com.cloud.serivce.PayMentSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class PayMentController {

    @Autowired
    private PayMentSerivce payMentSerivce;

    @Autowired
    private DiscoveryClient discoveryClient;


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

    @GetMapping("/payment/{id}")
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

    @GetMapping("/payment/discovery")
    public Object discoveryClient(){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("serivce", discoveryClient.getServices());
        for(String service:discoveryClient.getServices())
        {
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance serviceInstance:instances){
                System.out.println("***********************************");
                System.out.println("--------------host"+serviceInstance.getHost());
                System.out.println("--------------InstanceId"+serviceInstance.getInstanceId());
                System.out.println("--------------Uri"+serviceInstance.getUri());
                System.out.println("--------------ServiceId"+serviceInstance.getServiceId());
                System.out.println("--------------Scheme"+serviceInstance.getScheme());
                System.out.println("--------------Metadata"+serviceInstance.getMetadata());
            }
        }
        return discoveryClient;

    }


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
