package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Banner  {
    private  String id;
    private String title;
    private String image_path;
    private String description;
    private String status;
    private Data create_time;
}
