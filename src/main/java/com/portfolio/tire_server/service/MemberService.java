package com.portfolio.tire_server.service;

import com.portfolio.tire_server.mapper.MemberMapper;
import com.portfolio.tire_server.model.MemberModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberMapper memberMapper;

    public List<MemberModel> getAllMembers() {
        return memberMapper.findAllMembers();
    }

    public MemberModel findByIdAndPassword(String id, String password) {
        try {
            MemberModel member = memberMapper.findByIdAndPassword(id, password);
            if (member == null) {
                throw new RuntimeException("회원을 찾을 수 없습니다.");
            }
            return member;
        } catch (Exception e) {
            throw new RuntimeException("로그인 처리 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
}