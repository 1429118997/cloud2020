package com.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("cloud-alibaba-seata-storage")
public interface StorageService {

    @PostMapping("/storage/decCount")
    public void decCount(@RequestParam("produceId") long produceId, @RequestParam("count") long count);
}
