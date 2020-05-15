package com.cloud.service.impl;

import com.cloud.dao.StorageDao;
import com.cloud.entites.Order;
import com.cloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageDao storageDao;

    @Override
    public void decCount(long produceId, long count) {
          log.info("------------------>微服务调用，开始减库存");
          storageDao.decCount(produceId, count);
          log.info("------------------>微服务调用，结束减库存");
    }
}
