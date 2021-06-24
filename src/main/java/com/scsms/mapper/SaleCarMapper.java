package com.scsms.mapper;

import com.scsms.pojo.SaleCar;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SaleCarMapper {

    List<SaleCar> selectList(String brand, String series, Integer lowPrice, Integer highPrice);

    SaleCar selectOne(Integer id);

    void insert(SaleCar saleCar);//新车插入

    int selectCarId(String brand, String series, String model);//根据品牌，车系，款式查询car_id
}
