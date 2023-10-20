package com.scrcu.service;

import com.scrcu.entity.User;
import com.scrcu.pojo.Dept;
import com.scrcu.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

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


    List<User> selectAll();

    void batchDeleteUser(List<Integer> ids);

    User selectById(Integer id);

    User selectByoperTelrNo(Integer operTelrNo);

    PageBean selectPage(Integer page, Integer pageSize, String username, Integer operTelrNo, LocalDate begin, LocalDate end);
}
