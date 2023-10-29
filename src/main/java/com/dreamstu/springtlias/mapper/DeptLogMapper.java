package com.dreamstu.springtlias.mapper;/*
Name: DeptLogMapper
CreatDate: 2023/10/29 19:57
*/


import com.dreamstu.springtlias.pojo.DepLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptLogMapper {


    @Insert("insert into deplog (localDateTime, desp) VALUES (#{localDateTime}, #{desp})")
    void insertLog(DepLog depLog);
}
