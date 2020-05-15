package com.cloud;


import com.irule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableDiscoveryClient
//@RibbonClient(name = "CLOUD-PROVIDER-SERVICE",configuration = MyRule.class)
public class OrderMain80 {
    public static void main(String args[]){
        SpringApplication.run(OrderMain80.class,args);
    }
}
