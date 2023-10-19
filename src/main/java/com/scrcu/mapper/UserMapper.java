package com.scrcu.mapper;
import com.scrcu.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    /**
     * 新增员工信息
     */
    void insert(User user);

    /**
     * 根据柜员号删除用户
     */
    void deleteByoperTelrNo(Integer operTelrNo);

    /**
     * 根据柜员号更新用户
     */


    void updateUser(User user);

}
