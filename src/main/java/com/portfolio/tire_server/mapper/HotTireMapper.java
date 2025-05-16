package com.portfolio.tire_server.mapper;

import com.portfolio.tire_server.model.HotTireDTO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface HotTireMapper {
    List<HotTireDTO> getHotTires();
} 