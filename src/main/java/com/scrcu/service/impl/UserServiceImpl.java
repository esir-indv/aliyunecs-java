package com.scrcu.service.impl;

import com.scrcu.entity.User;
import com.scrcu.mapper.UserMapper;
import com.scrcu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        userMapper.insert(user);

    }

    @Override
    public void delete(Integer operTelrNo) {
        userMapper.deleteByoperTelrNo(operTelrNo);

    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);

    }
}
