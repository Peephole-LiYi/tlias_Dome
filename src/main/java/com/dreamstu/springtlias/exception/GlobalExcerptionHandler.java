package com.dreamstu.springtlias.exception;/*
Name: GlobalExcerptionHandler
CreatDate: 2023/10/28 21:01
*/

import com.dreamstu.springtlias.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExcerptionHandler {

    @ExceptionHandler()
    public Result ex(Exception e){
        e.printStackTrace();
        return Result.error("对不起,操作失败!");
    }
}
