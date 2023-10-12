package com.scrcu.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author: fengliang
 * @description: TODO
 * @date: 2023/10/11 15:41
 * @version: 1.0
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    //在请求处理之前进行调用（Controller方法调用前）
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("拦截器启动 ==> LoginInterceptor");
        return true;
    }
}
