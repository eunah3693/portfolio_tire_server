package com.portfolio.tire_server.controller;

import com.portfolio.tire_server.service.NoticeService;
import com.portfolio.tire_server.model.Notice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RestController
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeService noticeService;

    @GetMapping
    public List<Notice> getAllPosts() {
        return noticeService.getAllPosts();
    }

    @GetMapping("/{idx}")
    public Notice getPostByIdx(@PathVariable("idx") Long idx) {
        return noticeService.getPostByIdx(idx);
    }
} 