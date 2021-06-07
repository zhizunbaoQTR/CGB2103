package com.jt.controller;

import com.jt.pojo.User;
import com.jt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

//    @PostMapping("/addUser")
//    public String addUser(User user) {
//        userService.addUser(user);
//        return "新增成功!!!";
//    }

    @GetMapping("/getUser")
    public List<User> getUser() {
        List<User> userList = userService.getUser();
        return userList;
    }

    @GetMapping("/getUserById")
    public User getUserById(Integer id) {
        return userService.getUserById(id);
    }
    @GetMapping("/user/{id}")
    public User getUser (@PathVariable Integer id){
        return  userService.getUserById(id);
    }
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Integer id){

        userService.deleteUser(id);
        return "数据删除成功!!!";
    }
    /**
     * 接收post请求
     *  传递的参数是一个JSON串
     *      {"name":"黑熊精","age":3000,"sex":"男"}
     *  解决方案: 可以将JSON数据根据key:value 转化为对象(get/set方法)
     */
    @PostMapping("addUser")
    public String addUser(@RequestBody User user){
        System.out.println(user);
        userService.addUser(user);
        return "新增用户成功!!!";
    }
    @PostMapping("/addUserForm")
    public String addUserForm(User user){
        System.out.println(user);
        userService.addUser(user);
        return "新增用户成功!!!";
    }
    @PostMapping("/user/{name}/{age}/{sex}")
    public String addUserRest(User user){
        userService.addUser(user);
        return "restFul入库成功!!!";
    }
    @PutMapping("/user/{id}/{name}")
    public String updateUser(User user){
        userService.updateUser(user);
        return "修改数据成功";
    }
    /**
     * 实现修改操作
     * 参数: user的JSON数据
     * URL: /updateUser
     */
    @PutMapping("/updateUser")
    public String updateUser2(@RequestBody User user){

        userService.updateUser(user);
        return "实现数据修改";
    }
}
