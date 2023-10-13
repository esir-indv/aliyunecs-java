package com.scrcu.controller;
import com.scrcu.pojo.Dept;
import com.scrcu.pojo.Result;
import com.scrcu.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理
 */
@RestController
@Slf4j
//抽取公共路径
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    private DeptService deptService;
    /*
     * 查询部门数据
     * */
    @GetMapping
    public Result list() {
        log.info("查询全部部门数据");
        //调用service查询部门数据
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }
}
