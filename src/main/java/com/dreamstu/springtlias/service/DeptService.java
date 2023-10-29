package com.dreamstu.springtlias.service;/*
Name: DeptService
CreatDate: 2023/10/23 23:01
*/

import com.dreamstu.springtlias.pojo.Dept;

import java.util.List;


public interface DeptService {

    List<Dept> list();

    void delete(Integer id) throws Exception;

    void add(Dept dept);

    Dept selectByid(Integer id);

    void updateName(Dept dept);
}
