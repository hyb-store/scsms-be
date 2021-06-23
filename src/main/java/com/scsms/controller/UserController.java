package com.scsms.controller;

import com.alibaba.fastjson.JSON;
import com.scsms.response.ResponseData;
import com.scsms.pojo.User;
import com.scsms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody User u, HttpSession session, HttpServletResponse response) {
        if (u.getUsername() == null || u.getPassword() == null || u.getUsername().equals("") || u.getPassword().equals("")) {
            return JSON.toJSONString(new ResponseData(1, "用户名或密码为空", null));
        }

        //Cookie跨域
        response.setHeader("Access-Control-Allow-Credentials", "true");

        response.setHeader("SameSite", "None");
        //指定允许其他域名访问
        response.setHeader("Access-Control-Allow-Origin", "*");

        //允许的请求头字段
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        //设置预检请求的有效期
        //浏览器同源策略：出于安全考虑，浏览器限制跨域的http请求。怎样限制呢？通过发送两次请求：预检请求、用户请求。
        //1、预检请求作用：获知服务器是否允许该跨域请求：如果允许，才发起第二次真实的请求；如果不允许，则拦截第二次请求
        //2、单位:s,在此期间不用发送预检请求。
        //3、若为0：表示每次请求都发送预检请求,每个ajax请求之前都会先发送预检请求。
        response.setHeader("Access-Control-Max-Age", "3600");

        ResponseData responseData = null;
        User user = userService.login(u.getUsername(), u.getPassword());
        if (user == null) {
            responseData = new ResponseData(1, "用户名或密码错误!", null);
        } else {
            //密码正确
            user.setPassword(null);
            //Session
            session.setAttribute("user", user);
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
