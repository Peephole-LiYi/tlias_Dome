package com.dreamstu.springtlias.controller;/*
Name: EmpController
CreatDate: 2023/10/23 22:59
*/

import com.dreamstu.springtlias.pojo.Emp;
import com.dreamstu.springtlias.pojo.PageBean;
import com.dreamstu.springtlias.pojo.Result;
import com.dreamstu.springtlias.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;
    @GetMapping()
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
//        if (page == null) page = 1;
//        if (pageSize == null) pageSize = 10;
        log.info("分页查询 参数{}, {}, {}, {}, {}, {}", page, pageSize, name, gender, begin, end);
        PageBean pageBean = empService.page(page, pageSize, name, gender, begin, end);
        return Result.success(pageBean);
    }

    @DeleteMapping("/{ids}")
    public Result deletes(@PathVariable List<Integer> ids){

        empService.deletes(ids);
        log.info("删除: {}", ids);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Emp emp){

        empService.empAdd(emp);
        log.info("添加成功 {}", emp);

        return Result.success();
    }


    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id){
        Emp emp = empService.selectById(id);
        return Result.success(emp);
    }

    @PutMapping
    public Result chageEmp(@RequestBody Emp emp){
        empService.chageEmp(emp);
        return Result.success();
    }


}
