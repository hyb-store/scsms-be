package com.scsms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scsms.mapper.AdminMapper;
import com.scsms.pojo.SaleCar;
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
}
