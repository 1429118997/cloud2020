package com.cloud.serivce.impl;

import com.cloud.entites.Payment;
import com.cloud.mapper.PayMentMapper;
import com.cloud.serivce.PayMentSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PayMentSerivceImpl implements PayMentSerivce {

    @Resource
    private PayMentMapper payMentMapper;

    @Override
    public int insertPayMent(Payment payment) {
       return payMentMapper.insertPayMent(payment);
    }

    @Override
    public Payment queryPayMentForId(long id) {
        return payMentMapper.queryPayMentForId(id);
    }
}
