package com.scrcu.controller;

import com.scrcu.entity.User;
import com.scrcu.pojo.Dept;
import com.scrcu.pojo.PageBean;
import com.scrcu.pojo.Result;
import com.scrcu.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
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
    UserService userService;
    /**
     * 新增用户信息
     */
    @PostMapping("/add")
    public Result add(@RequestBody User user) {
        try {
            userService.insertUser(user);
        } catch (Exception e) {
            if (e instanceof DuplicateKeyException) {
                return Result.error("插入数据库错误");
            } else {
                return Result.error("系统错误");
            }
        }
        return Result.success();
    }

    /**
     * 根据柜员号删除信息
     */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) throws Exception {
        log.info("==>删除用户：{}", id);
        //调用service
        userService.delete(id);
        return Result.success();
    }
    /**
     * 批量根据柜员号删除信息
     */
    @DeleteMapping("/delete/batch")
    public Result batchDelete(@RequestBody List<Integer> ids) throws Exception {
        log.info("==>删除用户：{}", ids);
        //调用service
        userService.batchDeleteUser(ids);
        return Result.success();
    }
    /**
     * 更新用户信息
     */
    @PutMapping
    public Result update(@RequestBody User user) {
        log.info("更新员工信息：{}", user);
        userService.updateUser(user);
        return Result.success();
    }
    /*
     * 查询全部用户数据
     * */
    @GetMapping("/selectAll")
    public Result selectAll() {
        log.info("查询全部用户数据");
        //调用service查询部门数据
        List<User> userList = userService.selectAll();
        return Result.success(userList);
    }
    /*
     * 查询用户数据根据ID
     * */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        log.info("根据ID查询用户数据");
        //调用service查询部门数据
        User user = userService.selectById(id);
        return Result.success(user);
    }
    /*
     * 根据柜员号查询用户数据
     * */
    @GetMapping("/selectByoperTelrNo/{operTelrNo}")
    public Result selectByoperTelrNo(@PathVariable Integer operTelrNo) {
        log.info("根据柜员号查询用户数据");
        //调用service查询部门数据
        User user = userService.selectByoperTelrNo(operTelrNo);
        return Result.success(user);
    }

    /*
     * 模糊查询 : TODO
     * */


    /*
     * 分页查询&条件模糊查询：柜员号+用户名
     * */

    @GetMapping("/selectByPage")
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "5") Integer pageSize,
                       String username, Integer operTelrNo,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        log.info("分页查询，参数{},{},{},{},{},{}", page, pageSize, username, operTelrNo, begin, end);
        //调用service分页查询
        PageBean pageBean = userService.selectPage(page, pageSize, username, operTelrNo, begin, end);
        return Result.success(pageBean);
    }





}
