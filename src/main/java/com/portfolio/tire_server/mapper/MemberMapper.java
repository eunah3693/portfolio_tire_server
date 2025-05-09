package com.portfolio.tire_server.mapper;

import com.portfolio.tire_server.model.MemberModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    List<MemberModel> findAllMembers();
}