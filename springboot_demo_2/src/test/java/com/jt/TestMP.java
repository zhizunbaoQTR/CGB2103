package com.jt;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jt.mapper.UserMapper;
import com.jt.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class TestMP {
    @Autowired
//    @Resource  几乎不用,与autowired的区别:包不一样
    private UserMapper userMapper;

    @Test
    public void select01() {
        User user = userMapper.selectById(23);
        System.out.println(user);
    }

    @Test
    public void select02() {
        User user = new User();
        user.setName("潘凤").setSex("男");

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        List<User> userList = userMapper.selectList(queryWrapper);
        System.out.println(userList);
    }

    @Test
    public void select03() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age", 18)
                .or()
                .eq("sex", "男");
        List<User> userList = userMapper.selectList(queryWrapper);
        System.out.println(userList);
    }

    @Test
    public void select04() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeLeft("name", "精")
                .orderByDesc("age");
        List<User> userList = userMapper.selectList(queryWrapper);
        System.out.println(userList);
    }

    @Test
    public void select05() {
        Integer[] ids = {1, 3, 6, 7};
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.in("id", ids);
        //根据对象中不为null的属性,拼接where条件
        List<User> userList = userMapper.selectList(queryWrapper);
        System.out.println(userList);
    }

    @Test
    public void select06() {
        Integer[] ids = {1, 3, 6, 7};
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.isNull("name");
        //根据对象中不为null的属性,拼接where条件
        List<User> userList = userMapper.selectList(queryWrapper);
        System.out.println(userList);
    }

    @Test
    public void select07() {
        String sex = null;
        Integer age = 18;
//        boolean flag=sex !=null &&sex.length()>0;
        boolean flag = StringUtils.hasLength(sex);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt(age > 0, "age", age)
                .eq(flag, "sex", sex);
        //根据对象中不为null的属性,拼接where条件
        List<User> userList = userMapper.selectList(queryWrapper);
        System.out.println(userList);
    }

    @Test
    public void select08() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("name","age");
        List<User> userList = userMapper.selectList(queryWrapper);
        System.out.println(userList);

    }
    @Test
    public void select09(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("name","age");
        userMapper.selectMaps(queryWrapper);
        List<Map<String,Object>>list=userMapper.selectMaps(queryWrapper);
        System.out.println(list);
    }
    @Test
    public void select10(){
        List<Object> objects = userMapper.selectObjs(null);
        System.out.println(objects);
    }

}
