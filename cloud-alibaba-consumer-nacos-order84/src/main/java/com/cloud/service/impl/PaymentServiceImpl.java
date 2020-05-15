package com.cloud.service.impl;

import com.cloud.entites.CommonResult;
import com.cloud.service.PaymentService;
import org.springframework.stereotype.Component;

@Component
public class PaymentServiceImpl implements PaymentService {
    @Override
    public CommonResult queryPayMentForId(String id) {
        return new CommonResult(444,"淦");
    }
}
