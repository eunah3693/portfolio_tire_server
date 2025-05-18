package com.portfolio.tire_server.model;

import lombok.Data;
import java.util.Date;

@Data
public class Notice {
    private Long idx;
    private String title;
    private String content;
    private Date createdDate;
} 