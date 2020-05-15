package com.cloud.controller;

import com.cloud.IdSnowFlakeFlUntils;
import com.cloud.entites.CommonResult;
import com.cloud.entites.Order;
import com.cloud.service.AccountService;
import com.cloud.service.OrderService;
import com.cloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    public OrderService orderService;


    @GetMapping(value = "/order/create",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public CommonResult create(Order order){
       orderService.create(order);
       return new CommonResult(200,"订单创建成功");
    }


    @Autowired
    public IdSnowFlakeFlUntils idSnowFlakeFlUntils;

    @GetMapping("/snowflake")
    public void config(){
        ExecutorService executorService= Executors.newFixedThreadPool(5);
        for (int i=0;i<20;i++){
            executorService.submit(()->{
                System.out.println(idSnowFlakeFlUntils.snowflakeId());
            });
        }
        executorService.shutdown();
    }
}
