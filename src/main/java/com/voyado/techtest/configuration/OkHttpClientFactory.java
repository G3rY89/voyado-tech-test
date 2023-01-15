package com.voyado.techtest.configuration;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OkHttpClientFactory {
    @Bean
    public OkHttpClient OkHttpClientFactory() {
        return new OkHttpClient().newBuilder().build();
    }
}
