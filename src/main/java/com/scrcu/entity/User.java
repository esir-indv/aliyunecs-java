package com.scrcu.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author: fengliang
 * @description: TODO
 * @date: 2023/10/19 16:40
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    public Integer id;
    public String username;
    public String password;
    public String txOrgNo;
    public String phone;
    public String email;
    public Integer operTelrNo;
    public String avatar;
    //职位
    private String job;
    //创建时间
    private LocalDateTime createTime;
    //修改时间
    private LocalDateTime updateTime;

}
