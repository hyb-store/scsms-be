package com.scsms.service;

import com.github.pagehelper.PageInfo;
import com.scsms.pojo.SaleCar;

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
}
