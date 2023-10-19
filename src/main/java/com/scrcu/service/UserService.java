package com.scrcu.service;

import com.scrcu.entity.User;

public interface UserService {
    /**
     * 新增用户信息
     */
     void insertUser(User user);

    /**
     * 删除用户
     * @param id
     */
    void delete(Integer id);

    void  updateUser(User user);


}
