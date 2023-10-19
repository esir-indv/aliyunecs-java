package com.scrcu.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class  Result {

    public static final String CODE_SUCCESS = "200";
    public static final String CODE_AUTH_ERROR = "401";
    public static final String CODE_SYS_ERROR = "500";


    //响应码，1 代表成功; 0 代表失败
    private String code;
    //响应信息 描述字符串
    private String msg;
    //返回的数据
    private Object data;

    //增删改 成功响应
    public static Result success() {
        return new Result(CODE_SUCCESS, "success", null);
    }

    //查询 成功响应
    public static Result success(Object data) {
        return new Result(CODE_SUCCESS, "success", data);
    }
    //失败响应
    public static Result error(String msg) {
        return new Result(CODE_AUTH_ERROR, msg, null);
    }
    public static Result error(String code,String msg) {
        return new Result(code, msg, null);
    }
    public static Result error() {
        return new Result(CODE_SYS_ERROR, "系统错误", null);
    }
}
