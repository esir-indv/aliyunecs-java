package com.scrcu.config;

import com.scrcu.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    //拦截器-拦截路径,不拦截login资源
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //配置拦截请求范围
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/user/**");
    }
}
