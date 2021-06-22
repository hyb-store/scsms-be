package com.scsms.service;

import com.scsms.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {

    public User check(String username, String password);

    //检查用户名是否存在，存在为true，不存在为false
    public boolean checkUsername(String username);

    //注册
    public boolean register(User user);
}
