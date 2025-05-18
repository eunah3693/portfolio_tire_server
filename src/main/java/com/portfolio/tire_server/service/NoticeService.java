package com.portfolio.tire_server.service;

import com.portfolio.tire_server.mapper.NoticeMapper;
import com.portfolio.tire_server.model.Notice;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeMapper noticeMapper;

    public List<Notice> getAllPosts() {
        return noticeMapper.getAllPosts();
    }

    public Notice getPostByIdx(Long idx) {
        return noticeMapper.getPostByIdx(idx);
    }
} 