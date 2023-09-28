package com.example.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class MyConfigProto {
    @Bean
    public void MyConfigProto(){

    }
}
