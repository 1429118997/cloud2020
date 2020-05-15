package com.cloud;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 雪花算法生成
 * 时间回拨问题：可以利用扩展位解决时间回拨问题，但第一次回拨就重1024开始自增，如果第二次回拨就重2048开始自增，可以避免3次回拨问题
 *
 */
@Component
public class IdSnowFlakeFlUntils {
    private int workerId=0;
    private int datacenterId=0;
    private Snowflake snowflake=IdUtil.createSnowflake(0, 0);

    @PostConstruct
    public void init(){
        long workid = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
        System.out.println(workid);
    }

    public synchronized Long snowflakeId(){
        return snowflake.nextId();
    }

    public synchronized Long snowflakeId(int workerId,int datacenterId){
        Snowflake snowflake = IdUtil.createSnowflake(workerId, datacenterId);
        return snowflake.nextId();
    }


}
