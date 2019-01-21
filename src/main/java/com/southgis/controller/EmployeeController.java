package com.southgis.controller;

import com.google.common.collect.Maps;
import com.southgis.entity.Employee;
import com.southgis.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


/**
 * @Author: WenxiangChen
 * @Description:
 * @Date: Create in 14:28 2019/1/21
 * @Modified By:
 */
@Controller
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    /**
     * 新增员工信息
     *
     * @param employee 员工信息
     * @return
     */
    @PostMapping(value = "/employee/addEmployee")
    @ResponseBody
    public Object addEmployee(Employee employee) {
        return employeeService.addEmployee(employee);
    }

    /**
     * 根据数据标识获取员工信息
     *
     * @param id 员工数据标识
     * @return
     */
    @GetMapping(value = "/employee/getEmployeeById")
    @ResponseBody
    public Object getEmployeeById(String id) {
        return employeeService.getEmployeeById(id);
    }

    /**
     * 根据关键词分页查询员工信息
     *
     * @param key 关键词
     * @param pageable 分页参数(page默认为0,size默认为10)
     * @return
     */
    @GetMapping(value = "/employee/searchEmployees")
    @ResponseBody
    public Object searchEmployees(String key, @PageableDefault(page = 0,value = 10) Pageable pageable) {
        return employeeService.searchEmployees(key,pageable);
    }

}
