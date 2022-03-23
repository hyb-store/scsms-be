package com.scsms.service;

import java.util.List;
import java.util.Map;

public interface CarService {

    Map<String, List<String>> selectList();

    List<String> selectBrandList();

    List<String> selectSeriesLimit(String brand);

    List<String> selectSeriesList(String brand);

    List<String> selectModelList(String series);
}
