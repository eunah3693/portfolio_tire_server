package com.portfolio.tire_server.controller;

import com.portfolio.tire_server.service.RecommendTireService;
import com.portfolio.tire_server.model.RecommendTireDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RecommendTireController {
    private final RecommendTireService recommendTireService;

    @GetMapping("/tire/recommend")
    public List<RecommendTireDTO> getRecommendTires() {
        return recommendTireService.getRecommendTires();
    }
} 