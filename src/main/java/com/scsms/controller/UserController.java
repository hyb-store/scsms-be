package com.scsms.controller;

import com.alibaba.fastjson.JSON;
import com.scsms.response.ResponseData;
import com.scsms.pojo.User;
import com.scsms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {
        System.out.println(username);
        System.out.println(password);
        if (username == null || password == null || username.equals("") || password.equals("")) {
            return JSON.toJSONString(new ResponseData(1, "用户名或密码为空", null));
        }
        ResponseData response = null;
        User user = userService.check(username, password);
        if (user == null) {
            response = new ResponseData(1, "用户名或密码错误!", null);
        } else {
            //密码正确
            user.setPassword(null);
            //Session
            session.setAttribute("user", user);

            response = new ResponseData(0, "登录成功！", user);
        }
        return JSON.toJSONString(response);
    }

    @PostMapping("/register")
    public String register(@RequestParam("username") String username, @RequestParam("password") String password,
                           @RequestParam(value = "phonenum", required = false) String phoneNum,
                           @RequestParam(value = "email", required = false) String email, @RequestParam(value = "gender", required = false) Integer gender) {
        ResponseData response = null;
        if (username == null || password == null || username.equals("") || password.equals("")) {
            return JSON.toJSONString(new ResponseData(1, "用户名或密码为空", null));
        }

        User user = new User(username, password, phoneNum, email, gender);

        boolean registerStatus = userService.register(user);
        if (registerStatus) {
            user.setPassword(null);
            response = new ResponseData(0, "注册成功！", user);
        } else {
            response = new ResponseData(1, "账户已存在!", null);
        }

        return JSON.toJSONString(response);
    }

}
