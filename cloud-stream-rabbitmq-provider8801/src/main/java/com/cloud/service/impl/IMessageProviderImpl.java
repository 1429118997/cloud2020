package com.cloud.service.impl;

import com.cloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

import java.util.UUID;

@EnableBinding(Source.class)
public class IMessageProviderImpl implements IMessageProvider {

    @Autowired
    public MessageChannel output;


    @Override
    public String send() {
        String s = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(s).build());
        System.out.println(s);
        return s;
    }
}
