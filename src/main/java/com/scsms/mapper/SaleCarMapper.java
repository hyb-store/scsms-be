package com.scsms.mapper;

import com.scsms.pojo.SaleCar;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SaleCarMapper {

    List<SaleCar> selectList(String brand, String series, Integer lowPrice, Integer highPrice);

}
