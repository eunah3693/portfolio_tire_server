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

    public List<TireModel> getAllTires() {
        return tireMapper.findAllTires();
    }

    public TireModel getTireByIdx(int idx) {
        return tireMapper.findTireByIdx(idx);
    }

    public BrandModel getBrandByTireIdx(int idx) {
        return tireMapper.findBrandByTireIdx(idx);
    }
} 