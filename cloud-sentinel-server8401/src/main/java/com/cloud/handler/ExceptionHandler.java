package com.cloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class ExceptionHandler {
    public static String exceptionhandler(BlockException e){
        return "exceptionhandler";
    }
}
