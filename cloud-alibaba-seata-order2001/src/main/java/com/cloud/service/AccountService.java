package com.cloud.service;

import com.cloud.entites.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient("cloud-alibaba-seata-account")
public interface AccountService {

    @PostMapping("/account/decMoney")
    public CommonResult decMoney(@RequestParam("userId") long userId, @RequestParam("money") BigDecimal money);
}
