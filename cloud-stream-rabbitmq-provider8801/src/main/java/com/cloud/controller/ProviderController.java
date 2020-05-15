package com.cloud.controller;

import com.cloud.service.IMessageProvider;
import com.cloud.service.impl.IMessageProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    @Autowired
    private IMessageProvider iMessageProvider;

    @GetMapping("/send")
    public String send(){
        String send = iMessageProvider.send();
        return send;
    }
}
