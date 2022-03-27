package com.scsms.mapper;

import com.github.pagehelper.PageInfo;
import com.scsms.pojo.SaleCar;
import com.scsms.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminMapper {
    /**
     *  查询所有未审核的sale_car
     */
    List<SaleCar> selectPublishList();

    /**
     * 修改审核状态
     * @param publish -1：未通过  0：正在审核  1：审核通过
     * @return
     */
    void updatePublish(@Param("saleId") Integer saleId,@Param("publish") Integer publish);

    /**
     * 查找所有普通用户
     * @return
     */
    List<User> selectUserList();

    /**
     * 根据id删除用户
     * @param uid
     */
    void deleteUserById(Integer uid);
}
