package com.yizu.springboot.controller;

import com.yizu.springboot.dao.DepartmentDao;
import com.yizu.springboot.dao.EmployeeDao;
import com.yizu.springboot.entities.Department;
import com.yizu.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    // 查询员工列表
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
//        放在请求域中
        model.addAttribute("emps",employees);
        return "emp/list";

    }
//    员工添加页面
    @GetMapping("/emp")
    public  String toAddPage(Model model){
//        来到添加页面
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }
    //    员工添加
    @PostMapping("/emp")
    public  String addEmp(Employee employee){
//        来到添加页面
//        redirect:重定向到一个地址
//        forward:转发到一个地址
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    @GetMapping("/emp/{id}")
     public  String toEditPage(@PathVariable ("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
    //    回到修改页面
        //页面要显示所有的部门列表
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        //回到修改页面(add是一个修改添加二合一的页面);
        return "emp/add";
    }
//    员工修改
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";

    }
}
