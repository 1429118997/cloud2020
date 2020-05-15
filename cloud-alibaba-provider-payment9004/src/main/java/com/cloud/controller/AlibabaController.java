package com.cloud.controller;

import cn.hutool.crypto.SecureUtil;
import com.cloud.entites.CommonResult;
import com.cloud.entites.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class AlibabaController {

    @Value("${server.port}")
    public String port;
    public static HashMap<String, String> map = new HashMap<>();
    static {

        map.put("1", SecureUtil.md5("123"));
        map.put("2", SecureUtil.md5("124"));
        map.put("3", SecureUtil.md5("125"));
    }

    @GetMapping("/payment/{id}")
    public CommonResult queryPayMentForId(@PathVariable("id") String id){
        CommonResult commonResult=new CommonResult<>(200,map.get(id)+"\tport"+port);
        return commonResult;
    };
}
