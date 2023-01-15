package com.voyado.techtest.configuration;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GSonFactory {
    @Bean
    public Gson GsonFactory(){
        return new Gson();
    }
}
