package com.dreamstu.springtlias.service;/*
Name: DeptLogService
CreatDate: 2023/10/29 20:12
*/

import com.dreamstu.springtlias.pojo.DepLog;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public interface DeptLogService {
    void insertLog(DepLog depLog);
}
