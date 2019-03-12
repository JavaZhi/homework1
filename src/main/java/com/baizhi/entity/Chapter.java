package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chapter {
    private String id;
    private String title;
    private String url;
    private String size;
    private String duration;
    private Date create_time;
    private String albumId;
}
