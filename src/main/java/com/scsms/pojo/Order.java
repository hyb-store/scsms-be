package com.scsms.pojo;

import java.util.Date;

public class Order {

    private Integer id;
    private Integer saleCarId;
    private Integer buyerId; //买
    private Integer sellerId; //卖
    private Integer price;  //卖出价格
    private Date creatTime; //成交日期

    private SaleCar saleCar; //卖车信息

    public Order() {
    }

    public Order(Integer saleCarId, Integer storeId, Integer buyerId, Integer sellerId, Integer price, Date creatTime) {
        this.saleCarId = saleCarId;
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.price = price;
        this.creatTime = creatTime;
    }

    public SaleCar getSaleCar() {
        return saleCar;
    }

    public void setSaleCar(SaleCar saleCar) {
        this.saleCar = saleCar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSaleCarId() {
        return saleCarId;
    }

    public void setSaleCarId(Integer saleCarId) {
        this.saleCarId = saleCarId;
    }

    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }
}
