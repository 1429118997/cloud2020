package com.cloud.service.impl;

import com.cloud.dao.AccountDao;
import com.cloud.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@Service
public class AccountServiceImpl implements AccountService {
    private static Logger log= LoggerFactory.getLogger(AccountServiceImpl.class);
    @Autowired
    public AccountDao accountDao;

    @Override
    public void decMoney(long userId, BigDecimal money) {
        log.info("------------------>微服务调用，开始减余额");
        try {
            TimeUnit.SECONDS.sleep(60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountDao.decMoney(userId, money);
        log.info("------------------>微服务调用，开始减余额");
    }
}
