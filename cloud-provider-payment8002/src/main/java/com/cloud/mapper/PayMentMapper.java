package com.cloud.mapper;

import com.cloud.entites.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PayMentMapper {

    public int insertPayMent(Payment payment);

    public Payment queryPayMentForId(long id);
}
