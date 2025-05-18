package com.portfolio.tire_server.mapper;

import com.portfolio.tire_server.model.Community;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface CommunityMapper {
    List<Community> getAllPosts();
    Community getPostByIdx(Long idx);
} 