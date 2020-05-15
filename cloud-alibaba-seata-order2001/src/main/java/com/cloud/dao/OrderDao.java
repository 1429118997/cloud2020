package com.cloud.dao;

import com.cloud.entites.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDao {

    public void create(Order order);

    public void update(Long id);
}
