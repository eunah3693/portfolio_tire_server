package com.portfolio.tire_server.model;

import lombok.Data;

@Data
public class MemberModel {
    private int idx;
    private String name;
    private String id;
    private String password;
}