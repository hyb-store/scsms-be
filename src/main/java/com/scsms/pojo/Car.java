package com.scsms.pojo;

import java.io.Serializable;

public class Car implements Serializable {

    private Integer id;
    private String brand; //汽车品牌
    private String series; //汽车车系
    private String model; //汽车款式
    private String structure; //汽车车身结构(5门5座两厢车)
    private String fuel; //汽车的燃料类型(电动、汽油、混动)
    private String price; //汽车原价/厂商指导价

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", series='" + series + '\'' +
                ", model='" + model + '\'' +
                ", structure='" + structure + '\'' +
                ", fuel='" + fuel + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
