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
    private Integer views; //浏览量
    private Integer userId; //车主
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

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
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
                ", views=" + views +
                ", userId='" + userId + '\'' +
                ", createTime=" + createTime +
                ", car=" + car +
                '}';
    }
}
