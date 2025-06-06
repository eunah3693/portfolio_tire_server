package com.portfolio.tire_server.model;

import lombok.Data;

@Data
public class RecommendTireDTO {
    private Long idx;
    private Long tireIdx;
    private String name;
    private String description;
    private String brandName;
} 