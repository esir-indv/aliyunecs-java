package com.scrcu.controller;

import com.scrcu.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author: fengliang
 * @description: TODO
 * @date: 2023/10/12 14:12
 * @version: 1.0
 */
@Slf4j
@RestController
public class UserController {
    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable int id){
        log.info("用户ID："+id);
        return "根据ID获取用户";
    }
    @PostMapping("/user/post")
    public String save(User user){
        return "添加用户";
    }
    @PutMapping("/user/put")
    public String  update(User user){
        return "更新用户";
    }
    @DeleteMapping("/user/{id}")
    public String  deleteById(@PathVariable int id){
        return "根据用户ID删除用户";
    }
}
