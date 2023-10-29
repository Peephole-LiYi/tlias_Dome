package com.dreamstu.springtlias.mapper;/*
Name: EmpMapper
CreatDate: 2023/10/23 22:58
*/

import com.dreamstu.springtlias.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    //@Select("select * from emp")
    public List<Emp> page(String name, Short gender, LocalDate begin, LocalDate end);

    void deleteEmp(List<Integer> list);

    @Insert("insert into emp (username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "VALUES (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    void empAddMapper(Emp emp);


    Emp selectByIdMapper(Integer id);


    void update(Emp emp);

    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp getByusernameAndPassword(Emp emp);


    @Delete("delete from emp where dept_id = #{depId}")
    void deleteEmpById(Integer depId);
//    @Select("select count(*) from emp")
//    public Long count();
//
//    @Select("select * from emp limit #{start}, #{pageSize}")
//    public List<Emp> page(Integer start, Integer pageSize);



}
