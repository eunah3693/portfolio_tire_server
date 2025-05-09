package com.portfolio.tire_server.controller;

import com.portfolio.tire_server.model.TireModel;
import com.portfolio.tire_server.model.BrandModel;
import com.portfolio.tire_server.service.TireService;
import org.springframework.beans.factory.annotation.Autowired; //어노테이션 사용하기위한 import
import org.springframework.http.ResponseEntity; // http 응답 처리를 위한 import
import org.springframework.web.bind.annotation.GetMapping; // get 요청 처리를 위한 import
import org.springframework.web.bind.annotation.PathVariable; // 경로 변수 처리를 위한 import
import org.springframework.web.bind.annotation.RequestMapping; // 요청 경로 매핑을 위한 import
import org.springframework.web.bind.annotation.RestController; // Rest API 컨트롤러 역할을 하는 어노테이션

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tire")
public class TireController {

    @Autowired
    private TireService tireService;

    @GetMapping
    public List<TireModel> findAllTires() {
        return tireService.getAllTires();
    }

    @GetMapping("/{idx}")
    public ResponseEntity<Map<String, Object>> getTireByIdx(@PathVariable int idx) {
        TireModel tire = tireService.getTireByIdx(idx);
        if (tire != null) {
            BrandModel brand = tireService.getBrandByTireIdx(idx);
            Map<String, Object> response = new HashMap<>();
            response.put("tire", tire);
            response.put("brand", brand);
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }
}