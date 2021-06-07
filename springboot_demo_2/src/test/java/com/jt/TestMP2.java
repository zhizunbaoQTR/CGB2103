package com.jt;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.jt.mapper.UserMapper;
import com.jt.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestMP2 {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void updateUser(){
        User user = new User();
        user.setId(229).setName("六一儿童节");
        userMapper.updateById(user);

    }
    @Test
    public void updateUser2(){
        User user = new User();
        user.setName("端午节");
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.eq("name", "六一儿童节");
        userMapper.update(user,updateWrapper);
    }
}
