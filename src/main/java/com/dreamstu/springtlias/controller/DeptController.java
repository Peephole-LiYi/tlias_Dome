package com.dreamstu.springtlias.controller;/*
Name: DeptController
CreatDate: 2023/10/23 23:00
*/

import com.dreamstu.springtlias.pojo.Dept;
import com.dreamstu.springtlias.pojo.Emp;
import com.dreamstu.springtlias.pojo.Result;
import com.dreamstu.springtlias.service.DeptService;
import com.dreamstu.springtlias.service.EmpService;
import lombok.experimental.PackagePrivate;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
    //@RequestMapping(value = "/depts",method = RequestMethod.GET)

    @Autowired
    private DeptService deptService;
    @GetMapping()
    public Result list(){
        //将返回数据交由deptList
        List<Dept> deptList = deptService.list();
        log.info("全部成员信息查询成功！");
        return Result.success(deptList);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) throws Exception {
        log.info("根据部门删除ID：{}",id);
        deptService.delete(id);
        return Result.success();
    }

    @PostMapping()
    public Result add(@RequestBody Dept dept){
        log.info("新增部门：{}", dept);
        deptService.add(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result selectByid(@PathVariable Integer id){
        Dept dept = deptService.selectByid(id);
        return Result.success(dept);
    }

    @PutMapping
    public Result updateDept(@RequestBody Dept dept){
        deptService.updateName(dept);
        return Result.success();
    }

}
