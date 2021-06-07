package com.jt.mapper;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import java.util.List;

//@Mapper 为接口创建了反射机制一个对象
//MP规则:

public interface UserMapper extends BaseMapper<User> {

    //查询全部用户信息
    List<User> findAll();

    @Insert("insert into demo_user(id,name,age,sex)value (null,#{name},#{age},#{sex})")
    void insertUser(User user);

    @Update("update demo_user set name=#{newName} where name=#{oldName}")
    void updateByName(String oldName, String newName);

    @Delete("delete from demo_user where name=#{name}")
    void deleteByName(String name);

}
