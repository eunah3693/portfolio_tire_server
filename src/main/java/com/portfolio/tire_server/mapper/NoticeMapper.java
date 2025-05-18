package com.portfolio.tire_server.mapper;

import com.portfolio.tire_server.model.Notice;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface NoticeMapper {
    List<Notice> getAllPosts();
    Notice getPostByIdx(Long idx);
} 