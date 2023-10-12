package com.scrcu.controller;

import com.scrcu.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class HelloController {
    @GetMapping(value = "/hello")
    public String hello(String name) {
        return "Hello World :" + name;
    }
    //请求体封装为一个user类
    @PostMapping(value = "/user")
    public String user(@RequestBody User user){
        log.info("user:" + user);
        return "POST请求:"+ user.toString();
    }

}
