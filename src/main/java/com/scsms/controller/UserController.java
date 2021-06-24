package com.scsms.controller;

import com.alibaba.fastjson.JSON;
import com.scsms.response.ResponseData;
import com.scsms.pojo.User;
import com.scsms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody User u) {
        if (u.getUsername() == null || u.getPassword() == null || u.getUsername().equals("") || u.getPassword().equals("")) {
            return JSON.toJSONString(new ResponseData(1, "用户名或密码为空", null));
        }

        ResponseData responseData = null;
        User user = userService.login(u.getUsername(), u.getPassword());
        if (user == null) {
            responseData = new ResponseData(1, "用户名或密码错误!", null);
        } else {
            //密码正确
            user.setPassword(null);
            responseData = new ResponseData(0, "登录成功！", user);
        }

        return JSON.toJSONString(responseData);
    }

    @PostMapping("/register")
    public String register(@RequestBody User u) {
        if (u.getUsername() == null || u.getPassword() == null || u.getUsername().equals("") || u.getPassword().equals("")) {
            return JSON.toJSONString(new ResponseData(1, "用户名或密码为空", null));
        }
        ResponseData response = null;

        User user = userService.register(u);
        if (user != null) {
            u.setPassword(null);
            response = new ResponseData(0, "注册成功！", user);
        } else {
            response = new ResponseData(1, "用户名已存在!", null);
        }

        return JSON.toJSONString(response);
    }

}
