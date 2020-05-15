package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class GatewayMain9527 {

    public static void main(String args[]){
         SpringApplication.run(GatewayMain9527.class,args);
    }

//    @Bean
//    public RouteLocator getRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
//        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
//        routes.route("route3", r->r.path("/news").uri("https://news.baidu.com")).build();
//        return  routes.build();
//    }


}
