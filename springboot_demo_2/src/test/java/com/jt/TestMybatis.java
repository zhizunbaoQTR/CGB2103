package com.jt;

import com.jt.mapper.UserMapper;
import com.jt.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestMybatis {
    @Autowired(required = false)
    private UserMapper userMapper;

    @Test
    public void testInster() {
        System.out.println(userMapper.getClass());
        List<User> userList = userMapper.findAll();
        System.out.println(userList);
    }

    @Test
    public void inset() {
        User user = new User();
        user.setName("星期五").setAge(18).setSex("男");
        userMapper.insertUser(user);
        System.out.println("新增用户成功");
    }
    @Test
    public void update(){
        String oldName="星期五";
        String newName="星期六";
        userMapper.updateByName(oldName,newName);
        System.out.println("更新用户成功");
    }
    @Test
    public void delete(){
        String name="星期六";
        userMapper.deleteByName(name);
        System.out.println("删除用户成功");
    }


}
