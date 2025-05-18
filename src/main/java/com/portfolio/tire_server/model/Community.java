package com.portfolio.tire_server.model;

import lombok.Data;
import java.util.Date;

@Data
public class Community {
    private Long idx;
    private String id;
    private String title;
    private String content;
    private Date createdDate;
} 