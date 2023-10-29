package com.dreamstu.springtlias.service.impl;/*
Name: DeptLogServiceImpl
CreatDate: 2023/10/29 20:05
*/

import com.dreamstu.springtlias.mapper.DeptLogMapper;
import com.dreamstu.springtlias.pojo.DepLog;
import com.dreamstu.springtlias.service.DeptLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeptLogServiceImpl implements DeptLogService {

    @Autowired
    private DeptLogMapper deptLogMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void insertLog(DepLog depLog) {
        deptLogMapper.insertLog(depLog);
    }
}
