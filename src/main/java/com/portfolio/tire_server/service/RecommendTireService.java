package com.portfolio.tire_server.service;

import com.portfolio.tire_server.mapper.RecommendTireMapper;
import com.portfolio.tire_server.model.RecommendTireDTO;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendTireService {
    private final RecommendTireMapper recommendTireMapper;

    public List<RecommendTireDTO> getRecommendTires() {
        return recommendTireMapper.getRecommendTires();
    }
} 