package com.portfolio.tire_server.controller;

import com.portfolio.tire_server.service.HotTireService;
import com.portfolio.tire_server.model.HotTireDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class HotTireController {
    private final HotTireService hotTireService;

    @GetMapping("/tire/hot")
    public List<HotTireDTO> getHotTires() {
        return hotTireService.getHotTires();
    }
} 