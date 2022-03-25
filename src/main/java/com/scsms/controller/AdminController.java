package com.scsms.controller;

import com.github.pagehelper.PageInfo;
import com.scsms.pojo.SaleCar;
import com.scsms.response.ResponseData;
import com.scsms.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminServiceImpl adminService;

    @GetMapping("/list")//查询所有未审核的sale_car
    public ResponseData selectPublishList(@RequestParam(name = "page", defaultValue = "1") Integer page,
                                          @RequestParam(name = "size", defaultValue = "10") Integer size) {
        ResponseData responseData = null;
        PageInfo<SaleCar> saleCarPageInfo = adminService.selectPublishList(page, size);
        if (saleCarPageInfo != null) {
            responseData = new ResponseData(0, "查询成功", saleCarPageInfo);
        } else {
            responseData = new ResponseData(0, "未查询到结果", saleCarPageInfo);
        }
        return responseData;
    }

    @GetMapping("/publish")//-1：未通过  0：正在审核  1：审核通过
    public ResponseData updatePublish(@RequestParam(value = "saleId") Integer id,
                                      @RequestParam(value = "publish") Integer publish) {
        ResponseData responseData = null;
        if (id == null || id.equals("")|| publish == null || publish.equals("")) {
            responseData = new ResponseData(1, "参数为空，查询失败", null);
        }
        if (publish == 0 || publish == 1 || publish == -1) {
            adminService.updatePublish(id, publish);
            responseData = new ResponseData(0, "修改成功", null);
        } else {
            responseData = new ResponseData(1, "参数错误", null);
        }

        return responseData;
    }


}
