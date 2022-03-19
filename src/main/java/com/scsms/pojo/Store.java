package com.scsms.pojo;

import java.io.Serializable;
import java.util.List;

public class Store implements Serializable {

    private Integer id;
    private String name; //门店名称
    private String address; //地址
    private String phoneNum; //电话
    private String longitude; //经度
    private String latitude; //纬度
    private Integer counts; //门店总容量
    private Integer using_count; //已使用容量

    //一个门店有多个在卖的车
    private List<SaleCar> saleCars;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public Integer getUsing_count() {
        return using_count;
    }

    public void setUsing_count(Integer using_count) {
        this.using_count = using_count;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", counts=" + counts +
                ", using_count=" + using_count +
                '}';
    }
}
