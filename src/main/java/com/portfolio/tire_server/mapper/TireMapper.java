package com.portfolio.tire_server.mapper;

import com.portfolio.tire_server.model.TireModel;
import com.portfolio.tire_server.model.BrandModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TireMapper {
    List<TireModel> findAllTiresMapper();
    TireModel findTireByIdxMapper(int idx);
    BrandModel findBrandByTireIdxMapper(int idx);
}