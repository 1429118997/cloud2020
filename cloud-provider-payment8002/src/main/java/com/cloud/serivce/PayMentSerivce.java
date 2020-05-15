package com.cloud.serivce;

import com.cloud.entites.Payment;

public interface PayMentSerivce {
    public int insertPayMent(Payment payment);

    public Payment queryPayMentForId(long id);
}
