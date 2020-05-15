package com.cloud.LB;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalancer {

    public ServiceInstance instance(List<ServiceInstance> list);
}
