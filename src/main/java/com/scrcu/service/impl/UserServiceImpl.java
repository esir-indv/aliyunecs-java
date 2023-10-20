package com.scrcu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.scrcu.entity.User;
import com.scrcu.mapper.UserMapper;
import com.scrcu.pojo.PageBean;
import com.scrcu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: fengliang
 * @description: TODO
 * @date: 2023/10/19 16:51
 * @version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public void insertUser(User user) {
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userMapper.insert(user);
    }

    @Override
    public void delete(Integer id) {
        userMapper.deleteByoperTelrNo(id);

    }

    @Override
    public void updateUser(User user) {
        user.setUpdateTime(LocalDateTime.now());
        userMapper.updateUser(user);

    }
    @Override
    public void batchDeleteUser(List<Integer> ids) {
        userMapper.batchDeleteUser(ids);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public User selectById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public User selectByoperTelrNo(Integer operTelrNo) {
        return userMapper.selectByoperTelrNo(operTelrNo);
    }

    @Override
    public PageBean selectPage(Integer page, Integer pageSize, String username, Integer operTelrNo, LocalDate begin, LocalDate end) {

        //1、设置分页参数
        PageHelper.startPage(page, pageSize);
        //2、执行查询
        List<User> userList = userMapper.selectPage(username, operTelrNo, begin, end);
        Page<User> p = (Page<User>) userList;
        //3、封装PageBean对象
        return new PageBean(p.getTotal(), p.getResult());
    }
}
