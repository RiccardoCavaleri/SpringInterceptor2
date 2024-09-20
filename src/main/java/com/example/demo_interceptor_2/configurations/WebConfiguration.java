package com.example.demo_interceptor_2.configurations;

import com.example.demo_interceptor_2.interceptors.MonthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class WebConfiguration implements WebMvcConfigurer {
    //inietto la classe 'interceptor' di Month
    @Autowired
    private MonthInterceptor monthInterceptor;

    //Tramite il metodo fornito da WebMvcConfigurer, aggiungo e configuro monthInterceptor
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(monthInterceptor);
    }
}
