package com.scrcu.mapper;
import com.scrcu.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 新增员工信息
     */
    void insert(User user);

    /**
     * 根据柜员号删除用户
     */
    void deleteByoperTelrNo(Integer id);

    /**
     * 根据柜员号更新用户
     */


    void updateUser(User user);

    void batchDeleteUser(List<Integer> ids);

    List<User> selectAll();


    User selectById(Integer id);

    User selectByoperTelrNo(Integer operTelrNo);

    List<User> selectPage(String username, Integer operTelrNo, LocalDate begin, LocalDate end);
}
