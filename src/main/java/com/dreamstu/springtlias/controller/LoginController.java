package com.dreamstu.springtlias.controller;/*
Name: LoginController
CreatDate: 2023/10/26 21:55
*/

import com.dreamstu.springtlias.pojo.Emp;
import com.dreamstu.springtlias.pojo.Result;
import com.dreamstu.springtlias.service.EmpService;
import com.dreamstu.springtlias.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {


    @Autowired
    private EmpService empService;

    @PostMapping
    public Result login(@RequestBody Emp emp){

        log.info("员工登录 {}", emp);
        Emp e = empService.login(emp);

        //yes
        if (e != null){
            Map<String, Object> mapJwt = new HashMap<>();
            mapJwt.put("id", e.getId());
            mapJwt.put("name", e.getName());
            mapJwt.put("username", e.getUsername());
            String jwt = JwtUtils.generateJwt(mapJwt);
            return Result.success(jwt);
        }

        //no
     return Result.error("用户名密码错误");
    }
}
