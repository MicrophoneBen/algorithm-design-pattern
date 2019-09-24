package com.other.updown.domain.dto;

import java.util.Date;
import lombok.Data;

@Data
public class ImagesUpload {
    private Integer imageId;

    private String imageUrl;

    private Date createTime;

    private Date updateTime;
}