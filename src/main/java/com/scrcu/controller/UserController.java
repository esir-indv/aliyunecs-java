package com.scrcu.controller;

import com.scrcu.entity.User;
import com.scrcu.pojo.Result;
import com.scrcu.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLDataException;
import java.sql.SQLException;

/**
 * @author: fengliang
 * @description: TODO
 * @date: 2023/10/12 14:12
 * @version: 1.0
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl userService;

    /**
     * 新增用户信息
     */
    @PostMapping("/add")
    public Result add(@RequestBody User user){
        try {
            userService.insertUser(user);
        }catch (Exception e){
            if (e instanceof DuplicateKeyException){
                return Result.error("插入数据库错误");
            }
            else {
                return Result.error("系统错误");
            }
        }
        return Result.success();
    }
    /**
     * 根据柜员号删除信息
     */
    @DeleteMapping("/{operTelrNo}")
    public Result delete(@PathVariable Integer operTelrNo) throws Exception {
        log.info("==>删除用户：{}", operTelrNo);
        //调用service
        userService.delete(operTelrNo);
        return Result.success();
    }

    /**
     * 更新用户信息
     */

    @PutMapping
    public Result update(@RequestBody User user){
        log.info("更新员工信息：{}",user);
        userService.updateUser(user);
        return Result.success();
    }



}
