package com.scsms.service.impl;

import com.scsms.mapper.UserMapper;
import com.scsms.pojo.User;
import com.scsms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User check(String username, String password) {
        User user = userMapper.selectOne(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                //登陆成功
                return user;
            } else {
                //密码错误
                return null;
            }
        }

        return null;
    }

    @Override
    public boolean checkUsername(String username) {
        User user = userMapper.selectOne(username);
        if (user == null) {//不存在返回false
            return false;
        } else {//存在返回true
            return true;
        }
    }

    /**
     *  注册
     * @param user
     * @return  0.账户不存在，允许注册   1.账户存在，不能注册  2.账户或者密码为空
     */
    @Override
    public boolean register(User user) {
        if (user.getUsername() != null && user.getPassword() != null && !user.getUsername().equals("") && !user.getPassword().equals("")) {
            if (!checkUsername(user.getUsername())) {//不存在
                userMapper.register(user);
                return false;
            } else {//存在返回true
                return true;
            }
        }
        return false;
    }
}
