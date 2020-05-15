package com.cloud.dao;

import com.cloud.entites.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

@Mapper
public interface StorageDao {

    public void decCount(@Param("produceId") long produceId, @Param("count") long count);
}
