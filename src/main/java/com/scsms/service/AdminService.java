package com.scsms.service;

import com.github.pagehelper.PageInfo;
import com.scsms.pojo.SaleCar;
import com.scsms.pojo.User;

public interface AdminService {
    /**
     *  查询所有未审核的sale_car
     */
    PageInfo<SaleCar>  selectPublishList(int page, int size);

    /**
     * 修改审核状态
     * @param publish -1：未通过  0：正在审核  1：审核通过
     * @return
     */
    void updatePublish(Integer saleId, Integer publish);

    /**
     * 查找所有普通用户
     */
    PageInfo<User> selectUserList(int page, int size);

    /**
     * 根据id删除用户
     */
    void deleteUserById(Integer uid);
}
