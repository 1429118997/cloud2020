package com.cloud.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private long id;
    private long userId;
    private long produceId;
    private long count;
    private BigDecimal money;
    //订单状态： 0：创建中，1：创建完成
    private int status;
}
