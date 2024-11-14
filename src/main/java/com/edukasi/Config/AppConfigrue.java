package com.edukasi.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfigrue implements WebMvcConfigurer {
    @Autowired
    private Middleware middleware;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(middleware).addPathPatterns("/**");
    }
}
