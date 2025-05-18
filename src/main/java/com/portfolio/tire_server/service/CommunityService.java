package com.portfolio.tire_server.service;

import com.portfolio.tire_server.mapper.CommunityMapper;
import com.portfolio.tire_server.model.Community;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommunityService {
    private final CommunityMapper communityMapper;

    public List<Community> getAllPosts() {
        return communityMapper.getAllPosts();
    }

    public Community getPostByIdx(Long idx) {
        return communityMapper.getPostByIdx(idx);
    }
} 