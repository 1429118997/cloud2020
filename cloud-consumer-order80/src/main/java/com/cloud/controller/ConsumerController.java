package com.cloud.controller;

import com.cloud.LB.MyLRule;
import com.cloud.entites.CommonResult;
import com.cloud.entites.Payment;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private MyLRule myLRule;

    private static String PROVIDER_URL="http://CLOUD-PROVIDER-SERVICE/";

    @GetMapping("/consumer/payment")
    public CommonResult create(Payment payment){
        return restTemplate.postForObject(PROVIDER_URL+"payment",payment ,CommonResult.class );
    }

    @GetMapping("/consumer/payment/{id}")
    public CommonResult create(@PathVariable("id") long id){
        return restTemplate.getForObject(PROVIDER_URL+"payment/"+id ,CommonResult.class);
    }

    @GetMapping("/consumer/entites/{id}")
    public CommonResult queryEntites(@PathVariable("id") long id){
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(PROVIDER_URL + "payment/" + id, CommonResult.class);
        if (forEntity.getStatusCode().is2xxSuccessful()){
            log.info(""+forEntity.getStatusCodeValue());
            log.info(""+forEntity.getHeaders());
            System.out.println(""+forEntity.getStatusCodeValue());
            System.out.println(""+forEntity.getHeaders());
            return forEntity.getBody();
        }else{
            return new CommonResult(444,"runtest");
        }
    }

    @GetMapping("/consumer/lb")
    public String loadbalancer(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-SERVICE");
        ServiceInstance instance = myLRule.instance(instances);
        URI uri = instance.getUri();
        String port = restTemplate.getForObject(uri + "/payment/port", String.class);
        return port;
    }

}
