package com.voyado.techtest.configuration;

import com.voyado.techtest.util.SerpApiUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SerpApiFactory {
    @Bean
    public SerpApiUtil SerpApiFactory(){
        return new SerpApiUtil();
    }
}
