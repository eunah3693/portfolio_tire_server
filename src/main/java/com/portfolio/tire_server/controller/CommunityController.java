package com.portfolio.tire_server.controller;

import com.portfolio.tire_server.service.CommunityService;
import com.portfolio.tire_server.model.Community;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RestController
@RequestMapping("/community")
@RequiredArgsConstructor
public class CommunityController {
    private final CommunityService communityService;

    @GetMapping
    public List<Community> getAllPosts() {
        return communityService.getAllPosts();
    }

    @GetMapping("/{idx}")
    public Community getPostByIdx(@PathVariable("idx") Long idx) {
        return communityService.getPostByIdx(idx);
    }
} 