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
} 