package com.portfolio.tire_server.model;

import lombok.Data;

@Data
public class TireModel {
    private int idx;
    private int brand_idx;
    private String name;
    private String description;
}