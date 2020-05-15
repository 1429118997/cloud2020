package com.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface StorageService {

    @PostMapping("/storage/decCount")
    public void decCount( long produceId,  long count);
}
