package com.scsms.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaleCar implements Serializable {

    private Integer id;
    private Integer carId; //汽车id
    private Integer price; //上架价格
    private Integer km; //里程数(km)
    private String color; //颜色
    private Integer status; //0 或 1  代表 未卖出  和卖出
    private Integer views; //浏览量
    private Integer storeId; //上架门店
    private Integer userId; //车主
    private Date createTime; //上架日期
    private Date buyTime; //购买日期

    private Car car;  //一对一

    public Date getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Date buyTime) {
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(buyTime);
        Timestamp goodsC_date = Timestamp.valueOf(nowTime);//把时间转换
        this.buyTime = goodsC_date;
    }

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(createTime);
        Timestamp goodsC_date = Timestamp.valueOf(nowTime);//把时间转换
        this.createTime = goodsC_date;
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
                ", buyTime=" + buyTime +
                ", car=" + car +
                '}';
    }
}
