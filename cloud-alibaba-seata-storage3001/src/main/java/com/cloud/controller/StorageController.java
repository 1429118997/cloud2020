package com.cloud.controller;

import com.cloud.entites.CommonResult;
import com.cloud.entites.Order;
import com.cloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class StorageController {

    @Autowired
    public StorageService storageService;


    @PostMapping("/storage/decCount")
    public CommonResult decCount(@RequestParam("produceId") long produceId, @RequestParam("count") long count){
         storageService.decCount(produceId,count);
         return new CommonResult(200,"success");
    };
}
