package com.scrcu.mapper;
import com.scrcu.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface DeptMapper {
    /**
     * 查询全部部门
     */
    List<Dept> list();

}
