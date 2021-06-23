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
    public User login(String username, String password) {
        User user = userMapper.selectOne(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                //登陆成功
                return user;
            }
        }

        return null;
    }

    @Override
    public User register(User user) {
        if (user.getUsername() != null && user.getPassword() != null && !user.getUsername().equals("") && !user.getPassword().equals("")) {
            if (userMapper.selectOne(user.getUsername()) == null) {
                userMapper.register(user);
                return user;
            }
        }
        return null;
    }
}
