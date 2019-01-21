package com.southgis.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

/**
 * @Author: WenxiangChen
 * @Description:
 * @Date: Create in 14:20 2019/1/21
 * @Modified By:
 */
@Data
@Document(indexName = "company",type = "employee")
public class Employee {

    @Id
    private String id;

    @Field
    private String firstName;

    @Field
    private String lastName;

    @Field
    private int age = 0;

    @Field
    private String about;
}
