package com.dreamstu.springtlias.mapper;/*
Name: DeptMapper
CreatDate: 2023/10/23 22:58
*/

import com.dreamstu.springtlias.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {

    /**
     *
     * @author Administrator
     * @date 2023/10/24 13:25
     * @methodName list
     * @description 查询所有数据
     * @return
     */
    @Select("select * from dept")
    List<Dept> list();

    /**
     *
     * @author Administrator
     * @date 2023/10/24 13:25
     * @methodName deleteById
     * @description 根据ID删除数据
     * @return
     */
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    /**
     *
     * @author Administrator
     * @date 2023/10/24 14:17
     * @methodName add
     * @description 添加部门
     * @return
     */
    @Insert("insert into dept (name, create_time, update_time) VALUES (#{name},#{createTime},#{updateTime})")
    void add(Dept dept);

    /**
     *
     * @author Administrator
     * @date 2023/10/24 17:02
     * @methodName selectDept
     * @description 根据ID查询部门
     * @return
     */

    @Select("select * from dept where id = #{id}")
    Dept selectDept(Integer id);

    /**
     *
     * @author Administrator
     * @date 2023/10/24 17:02
     * @methodName update
     * @description 更新部门
     * @return
     */

    @Update("update dept set name = #{name}, update_time = #{updateTime} where id = #{id};")
    void update(Dept dept);
}
