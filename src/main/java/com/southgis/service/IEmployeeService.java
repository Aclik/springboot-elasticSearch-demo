package com.southgis.service;

import com.southgis.entity.Employee;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Author: WenxiangChen
 * @Description:
 * @Date: Create in 14:28 2019/1/21
 * @Modified By:
 */
public interface IEmployeeService {

    /**
     * 新增员工信息
     *
     * @param employee 员工信息
     * @return
     */
    Employee addEmployee(Employee employee);

    /**
     * 根据数据标识获取员工信息
     *
     * @param id 数据标识
     * @return
     */
    Employee getEmployeeById(String id);

    /**
     * 根据关键词分页查询员工信息
     *
     * @param key 关键词
     * @param pageable 分页参数(page默认为0,size默认为10)
     * @return
     */
    List<Employee> searchEmployees(String key, Pageable pageable);
}
