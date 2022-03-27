package com.scsms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scsms.mapper.AdminMapper;
import com.scsms.pojo.SaleCar;
import com.scsms.pojo.User;
import com.scsms.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public PageInfo<SaleCar> selectPublishList(int page, int size) {
        PageHelper.startPage(page, size);
        List<SaleCar> saleCars = adminMapper.selectPublishList();
        return new PageInfo<>(saleCars);
    }

    @Override
    public void updatePublish(Integer saleId, Integer publish) {
        adminMapper.updatePublish(saleId, publish);
    }

    @Override
    public PageInfo<User> selectUserList(int page, int size) {
        PageHelper.startPage(page, size);
        List<User> users = adminMapper.selectUserList();
        for (User user : users) {
            user.setPassword(null);
        }
        return new PageInfo<>(users);
    }

    @Override
    public void deleteUserById(Integer uid) {
        adminMapper.deleteUserById(uid);
    }
}
