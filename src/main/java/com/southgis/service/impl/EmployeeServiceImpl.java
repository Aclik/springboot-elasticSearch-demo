package com.southgis.service.impl;

import com.southgis.entity.Employee;
import com.southgis.repository.EmployeeRepository;
import com.southgis.service.IEmployeeService;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: WenxiangChen
 * @Description:
 * @Date: Create in 14:28 2019/1/21
 * @Modified By:
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(String id) {
        return employeeRepository.findEmployeeById(id);
    }

    @Override
    public List<Employee> searchEmployees(String key, Pageable pageable) {
        QueryStringQueryBuilder queryStringQueryBuilder = new QueryStringQueryBuilder(key);
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withPageable(pageable).withQuery(queryStringQueryBuilder).build();
        Page<Employee> employeeIterable = employeeRepository.search(searchQuery);
        return employeeIterable.getContent();
    }
}
