package com.scsms.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CarMapper {

    List<String> selectBrandLimit();// 默认15

    List<String> selectBrandList();// 全部

    List<String> selectSeriesLimit();//查车系，默认10

    List<String> selectSeriesLimitByBrand(String brand);//根据品牌查车系，默认10

    List<String> selectSeriesList(String brand);// 根据品牌查所有车系

    List<String> selectModelList(String series);
}
