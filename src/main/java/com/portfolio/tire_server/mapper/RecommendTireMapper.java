package com.portfolio.tire_server.mapper;

import com.portfolio.tire_server.model.RecommendTireDTO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface RecommendTireMapper {
    List<RecommendTireDTO> getRecommendTires();
} 