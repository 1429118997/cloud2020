package com.cloud.controller;

import com.cloud.entites.CommonResult;
import com.cloud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@RestController
public class AccountCotroller {

    @Autowired
    public AccountService accountService;

    @PostMapping("/account/decMoney")
    public CommonResult decMoney(@RequestParam("userId") long userId, @RequestParam("money") BigDecimal money){
        accountService.decMoney(userId,money);
        return new CommonResult(200,"success");
    };
}
