package com.yizu.springboot.mapper;

import com.yizu.springboot.entities.Department;
import com.yizu.springboot.entities.Employee;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

//指定这是一个操作数据库的mapper

public interface EmployeeMapper {

    @Select("select * from employee where id =#{id} ")
    public Department getEmplById(Integer id);

    @Delete("delete  from employee where id =#{id} ")
    public int deleteEmplById(Integer id);

    @Insert("insert into employee(lasName,email,gender,d_id,birth) values#{lasName,email,gender,d_id,birth} ")
    public int insertEmplById(Employee employee);

    @Update("update employee set lasName =#{lasName},email =#{email},gender =#{gender},d_id =#{d_id},birth =#{birth}  where id=#{id}")
    public int updateEmplById(Employee employee);
}
