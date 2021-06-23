package com.scsms.pojo;

import java.io.Serializable;
import java.util.Date;

public class SaleCar implements Serializable {

    private Integer id;
    private Integer carId; //汽车id
    private String price; //上架价格
    private Integer km; //里程数(km)
    private String color; //颜色
    private Integer status; //0 或 1  代表 未卖出  和卖出
    private Integer views; //浏览量
    private Integer storeId; //上架门店
    private String userId; //车主
    private Date createTime; //上架日期

    private Car car;  //一对一

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getKm() {
        return km;
    }

    public void setKm(Integer km) {
        this.km = km;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "SaleCar{" +
                "id=" + id +
                ", carId=" + carId +
                ", price='" + price + '\'' +
                ", km=" + km +
                ", color='" + color + '\'' +
                ", status=" + status +
                ", views=" + views +
                ", storeId=" + storeId +
                ", userId='" + userId + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
