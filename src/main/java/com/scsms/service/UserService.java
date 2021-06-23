package com.scsms.service;

import com.scsms.pojo.User;

public interface UserService {

    User login(String username, String password);

    //注册
    User register(User user);
}
