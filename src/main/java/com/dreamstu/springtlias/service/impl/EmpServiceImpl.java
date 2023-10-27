package com.dreamstu.springtlias.service.impl;/*
Name: EmpServiceImpl
CreatDate: 2023/10/23 23:02
*/

import com.dreamstu.springtlias.mapper.EmpMapper;
import com.dreamstu.springtlias.pojo.Emp;
import com.dreamstu.springtlias.pojo.PageBean;
import com.dreamstu.springtlias.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    /**
     *
     * @author Administrator
     * @date 2023/10/24 20:58
     * @methodName page
     * @description 处理员工数据分页展示
     * @return
     */

    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {

        //1,数据条数
        PageHelper.startPage(page, pageSize);
        //Long count = empMapper.count();

        //2分页展示
        //Integer i = (page - 1) * pageSize;
        List<Emp> empList = empMapper.page(name,gender,begin,end);
        Page<Emp> page1 = (Page<Emp>) empList;

        //3返回数据

        return new PageBean(page1.getTotal(), page1.getResult());
    }


    /**
     * @Description 批量删除
     * @Author lhbll
     * @Date 2023/10/25 20:05
     * @Version 1.0
    */
    @Override
    public void deletes(List<Integer> list) {

        empMapper.deleteEmp(list);
//        for (Integer integer : list) {
//            empMapper.deleteEmp(integer);
//        }

    }


    /**
     * @Description 添加员工
     * @Author lhbll
     * @Date 2023/10/25 20:05
     * @Version 1.0
    */
    @Override
    public void empAdd(Emp emp) {

        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());

        empMapper.empAddMapper(emp);
    }

    /**
     * @Description 根据ID查找员工数据返回
     * @Author lhbll
     * @Date 2023/10/25 20:06
     * @Version 1.0
    */
    @Override
    public Emp selectById(Integer id) {
        Emp getEmpByMapper = empMapper.selectByIdMapper(id);
        return getEmpByMapper;
    }


    /**
     * @Description 修改员工数据
     * @Author lhbll
     * @Date 2023/10/25 20:06
     * @Version 1.0
    */
    @Override
    public void chageEmp(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());

        empMapper.update(emp);
    }

    @Override
    public Emp login(Emp emp) {



        return empMapper.getByusernameAndPassword(emp);
    }


}
