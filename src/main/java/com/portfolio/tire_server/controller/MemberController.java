package com.portfolio.tire_server.controller;

import com.portfolio.tire_server.model.MemberModel;
import com.portfolio.tire_server.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping
    public List<MemberModel> findAllMembers() {
        return memberService.getAllMembers();
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
        String id = loginRequest.get("id");
        String password = loginRequest.get("password");
        
        // 입력값 검증
        if (id == null || id.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("아이디를 입력해주세요.");
        }
        if (password == null || password.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("비밀번호를 입력해주세요.");
        }

        try {
            MemberModel member = memberService.findByIdAndPassword(id, password);
            if (member == null) {
                return ResponseEntity.badRequest().body("아이디 또는 비밀번호가 일치하지 않습니다.");
            }

            // 응답 데이터 구성
            Map<String, Object> response = new HashMap<>();
            response.put("id", member.getId());
            response.put("name", member.getName());
            response.put("message", "success");

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("로그인 처리 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    
}