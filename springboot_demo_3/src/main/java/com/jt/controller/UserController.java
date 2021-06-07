package com.jt.controller;

import com.jt.pojo.User;
import com.jt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/addUser")
    public String addUser(User user){
        userService.addUser(user);
        return "新增成功!!!";
    }
    @GetMapping("/getUser")
    public List<User> getUser(){
        List<User> userList=userService.getUser();
        return userList;
    }

}
