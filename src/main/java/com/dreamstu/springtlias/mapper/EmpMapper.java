package com.dreamstu.springtlias.mapper;/*
Name: EmpMapper
CreatDate: 2023/10/23 22:58
*/

import com.dreamstu.springtlias.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    //@Select("select * from emp")
    public List<Emp> page(String name, Short gender, LocalDate begin, LocalDate end);



    void deleteEmp(List<Integer> list);

//    @Select("select count(*) from emp")
//    public Long count();
//
//    @Select("select * from emp limit #{start}, #{pageSize}")
//    public List<Emp> page(Integer start, Integer pageSize);



}
