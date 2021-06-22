package com.scsms.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.scsms.response.ResponseData;
import com.scsms.pojo.User;
import com.scsms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody User u, HttpSession session) {
        if (u.getUsername() == null || u.getPassword() == null || u.getUsername().equals("") || u.getPassword().equals("")) {
            return JSON.toJSONString(new ResponseData(1, "用户名或密码为空", null));
        }

        ResponseData response = null;
        User user = userService.check(u.getUsername(), u.getPassword());
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
    public String register(@RequestBody User user) {
        if (user.getUsername() == null || user.getPassword() == null || user.getUsername().equals("") || user.getPassword().equals("")) {
            return JSON.toJSONString(new ResponseData(1, "用户名或密码为空", null));
        }
        ResponseData response = null;

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
