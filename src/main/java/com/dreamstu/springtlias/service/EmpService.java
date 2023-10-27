package com.dreamstu.springtlias.service;/*
Name: EmpService
CreatDate: 2023/10/23 23:01
*/

import com.dreamstu.springtlias.pojo.Emp;
import com.dreamstu.springtlias.pojo.PageBean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;


@Component
public interface EmpService {

    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    void deletes(List<Integer> list);

    void empAdd(Emp emp);

    Emp selectById(Integer id);

    void chageEmp(Emp emp);

    Emp login(Emp emp);
}
