package com.cloud.service;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

public interface AccountService {

    public void decMoney(long userId, BigDecimal money);
}
