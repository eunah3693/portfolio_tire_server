package com.portfolio.tire_server.service;

import com.portfolio.tire_server.mapper.TireMapper;
import com.portfolio.tire_server.model.TireModel;
import com.portfolio.tire_server.model.BrandModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TireService {

    @Autowired
    private TireMapper tireMapper;

    public List<TireModel> getAllTiresService() {
        return tireMapper.findAllTiresMapper();
    }

    public TireModel getTireByIdxService(int idx) {
        return tireMapper.findTireByIdxMapper(idx);
    }

    public BrandModel getBrandByTireIdxService(int idx) {
        return tireMapper.findBrandByTireIdxMapper(idx);
    }
} 