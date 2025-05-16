package com.portfolio.tire_server.service;

import com.portfolio.tire_server.mapper.HotTireMapper;
import com.portfolio.tire_server.model.HotTireDTO;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HotTireService {
    private final HotTireMapper hotTireMapper;

    public List<HotTireDTO> getHotTires() {
        return hotTireMapper.getHotTires();
    }
} 