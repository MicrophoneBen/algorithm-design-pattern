package com.other.updown.domain.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.other.updown.domain.BaseEntity;
import com.other.updown.utils.DateUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper=true)
public class BitmapResponseBody extends BaseEntity {

    private static final long serialVersionUID = 173822225923672409L;

    /**
     * 响应状态码
     */
    @ApiModelProperty(value="响应状态码")
    @JsonProperty(value="statusCode")
    @JSONField(name="statusCode")
    private Integer statusCode;
    
    /**
     * bitset 16进制字符串
     */
    @ApiModelProperty(value="设备ID bitset 16进制字符串")
    @JsonProperty(value="bitmap")
    @JSONField(name="bitmap")
    private String bitmap;
    
    /**
     * 请求时间戳
     */
    @ApiModelProperty(value="请求时间戳")
    @JsonProperty(value="timestamp")
    @JSONField(name="timestamp", format= DateUtil.yyyyMMddHHmmss_style)
    private Date timestamp;
    
    /**
     * MD5(bitset 16进制字符串)
     */
    @ApiModelProperty(value="MD5(设备ID bitset 16进制字符串)")
    @JsonProperty(value="bitmapmd5")
    @JSONField(name="bitmapmd5")
    private String bitmapmd5;
    
}
