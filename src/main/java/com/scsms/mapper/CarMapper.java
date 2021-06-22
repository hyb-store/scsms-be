package com.scsms.mapper;

import com.scsms.pojo.SaleCar;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CarMapper {

    public List<SaleCar> selectAll();

}
