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

@RestController // Rest API 컨트롤러 역할을 하는 어노테이션
@RequestMapping("/tire") // API 엔드포인트 지정 
public class TireController {

    @Autowired //tireService 객체를 주입해줌 : 의존성 주입 
    private TireService tireService; // tireService 객체 생성 

    @GetMapping 
    public List<TireModel> findAllTiresController() { // List<TireModel> : tire 모델을 리스트로 반환, findAllTires() : 모든 tire 모델을 조회하는 메서드 
        return tireService.getAllTiresService(); // tireService 객체의 getAllTires() 메서드를 호출하여 모든 tire 모델을 조회하고 반환 
    }

    @GetMapping("/{idx}")
    public ResponseEntity<Map<String, Object>> getTireByIdx(@PathVariable("idx") int idx) {
        TireModel tire = tireService.getTireByIdxService(idx);
        if (tire != null) {
            BrandModel brand = tireService.getBrandByTireIdxService(idx);
            Map<String, Object> response = new HashMap<>();
            response.put("tire", tire);
            response.put("brand", brand);
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }
}