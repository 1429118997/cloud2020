package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class hystrixDashBoardMain7004 {

    public static void main(String args[]){
         SpringApplication.run(hystrixDashBoardMain7004.class,args);
    }

}
