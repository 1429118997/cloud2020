package com.cloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.math.BigDecimal;

@Mapper
public interface AccountDao {

    public void decMoney(@Param("userId") long userId, @Param("money") BigDecimal money);
}
