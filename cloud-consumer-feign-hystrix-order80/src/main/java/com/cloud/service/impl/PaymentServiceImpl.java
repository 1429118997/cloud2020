package com.cloud.service.impl;

import com.cloud.service.PaymentService;
import org.springframework.stereotype.Component;

@Component
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String payment_ok() {
        return "gan";
    }

    @Override
    public String payment_timeout(int id) {
        return "?????";
    }
}
