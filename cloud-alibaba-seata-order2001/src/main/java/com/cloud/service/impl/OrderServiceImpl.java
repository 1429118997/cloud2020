package com.cloud.service.impl;

import com.cloud.dao.OrderDao;
import com.cloud.entites.Order;
import com.cloud.service.AccountService;
import com.cloud.service.OrderService;
import com.cloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    public StorageService storageService;
    @Autowired
    public AccountService accountService;

    @GlobalTransactional(name = "cloud_tx",rollbackFor = Exception.class)
    @Override
    public void create(Order order) {
        log.info("------------------->开始创建订单");
        orderDao.create(order);

        log.info("------------------>微服务调用，开始减库存");
        storageService.decCount(order.getProduceId(),order.getCount());
        log.info("--------------------->微服务调用，结束减库存");

        log.info("------------------>微服务调用，开始减余额");
        accountService.decMoney(order.getUserId(),order.getMoney());
        log.info("------------------>微服务调用，结束减余额");

        log.info("------------------>修改订单状态");
        orderDao.update(order.getId());
        log.info("------------------>订单创建结束");
    }


}
