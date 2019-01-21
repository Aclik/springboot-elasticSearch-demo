package com.southgis.repository;

import com.southgis.entity.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: WenxiangChen
 * @Description:
 * @Date: Create in 14:24 2019/1/21
 * @Modified By:
 */
@Repository
public interface EmployeeRepository extends ElasticsearchRepository<Employee,String> {

    /**
     * 根据数据标识获取员工信息
     *
     * @param id 员工数据标识
     * @return
     */
    Employee findEmployeeById(String id);
}
