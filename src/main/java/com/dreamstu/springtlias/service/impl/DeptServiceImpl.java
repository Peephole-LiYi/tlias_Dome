package com.dreamstu.springtlias.service.impl;/*
Name: EmpServiceImpl
CreatDate: 2023/10/23 23:02
*/

import com.dreamstu.springtlias.mapper.DeptMapper;
import com.dreamstu.springtlias.mapper.EmpMapper;
import com.dreamstu.springtlias.pojo.DepLog;
import com.dreamstu.springtlias.pojo.Dept;
import com.dreamstu.springtlias.service.DeptLogService;
import com.dreamstu.springtlias.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private DeptLogServiceImpl deptLogService;

    /**
     *
     * @author Administrator
     * @date 2023/10/24 17:00
     * @methodName list
     * @description 查询全部部门
     * @return 返回一个部门对象数组
     */

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    /**
     *
     * @author Administrator
     * @date 2023/10/24 17:00
     * @methodName delete
     * @description 删除部门
     * @return
     */

    @Transactional
    @Override
    public void delete(Integer id) throws Exception {

        try {

            deptMapper.deleteById(id);
//            int i = 1 / 0;
            empMapper.deleteEmpById(id);
//        if (true) {
//            throw new Exception();
//        }




        } finally {
            DepLog depLog = new DepLog();
            depLog.setLocalDateTime(LocalDateTime.now());
            depLog.setDesp("删除部门,当前是部门ID为 :" + id);
            deptLogService.insertLog(depLog);
        }


    }

    /**
     *
     * @author Administrator
     * @date 2023/10/24 16:58
     * @methodName add
     * @description 添加部门
     * @return 
     */
    
    @Override
    public void add(Dept dept) {

        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        deptMapper.add(dept);

    }

    /**
     * @return 返回一个部门对象
     * @author Administrator
     * @date 2023/10/24 16:28
     * @methodName selectByid
     * @description 根据ID查询是否存在部门
     */

    @Override
    public Dept selectByid(Integer id) {

        return deptMapper.selectDept(id);
    }

    /**
     *
     * @author Administrator
     * @date 2023/10/24 16:58
     * @methodName updateName
     * @description 更新部门数据的逻辑
     * @return 
     */
    
    @Override
    public void updateName(Dept dept) {

        dept.setUpdateTime(LocalDateTime.now());

        deptMapper.update(dept);
    }


}
