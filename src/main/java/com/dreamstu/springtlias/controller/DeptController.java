package com.dreamstu.springtlias.controller;/*
Name: DeptController
CreatDate: 2023/10/23 23:00
*/

import com.dreamstu.springtlias.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class DeptController {
    @RequestMapping("/depts")
    public Result list(){
        log.info("全部成员信息查询成功！");
        return Result.success();
    }
}
