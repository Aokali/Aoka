package com.yizu.springboot.mapper;

import com.yizu.springboot.entities.Department;
import org.apache.ibatis.annotations.*;

//指定这是一个操作数据库的mapper
@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id =#{id} ")
    public Department getDeptById(Integer id);

    @Delete("delete  from department where id =#{id} ")
    public int deleteDeptById(Integer id);

    @Insert("insert into department(departmentName) values#{departmentName} ")
    public int insertDeptById(Department department);

    @Update("update department set departmentName =#{departmentName}  where id=#{id}")
    public int updateDeptById(Department department);
}
