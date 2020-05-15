package com.cloud.config;

import com.sun.javafx.binding.Logging;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenFeignConfig {
     @Bean
    public Logger.Level level(){
         return Logger.Level.FULL;
     }
}
