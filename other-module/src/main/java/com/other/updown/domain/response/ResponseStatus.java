package com.other.updown.domain.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.other.updown.constant.ResponseStatusType;
import com.other.updown.domain.BaseEntity;
import com.other.updown.domain.jsonkey.ResponseStatusJsonKey;
import com.other.updown.utils.DateUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 单个新增、删除、修改返回应答状态对象列表
 * 
 */
@Data
public class ResponseStatus extends BaseEntity {
    private static final long serialVersionUID = 2015789671965355455L;
    
    @ApiModelProperty(value="资源定位符")
    @JsonProperty(value= ResponseStatusJsonKey.REQUEST_URL)
    @JSONField(name = ResponseStatusJsonKey.REQUEST_URL, ordinal = 1)
    private String requestURL;
    
    @ApiModelProperty(value="状态码")
    @JsonProperty(value=ResponseStatusJsonKey.STATUS_CODE)
    @JSONField(name = ResponseStatusJsonKey.STATUS_CODE, ordinal = 2)
    private Integer statusCode;
    
    @ApiModelProperty(value="状态描述")
    @JsonProperty(value=ResponseStatusJsonKey.STATUS_STRING)
    @JSONField(name = ResponseStatusJsonKey.STATUS_STRING, ordinal = 3)
    private String statusString;
    
    @ApiModelProperty(value="资源 ID")
    @JSONField(name = ResponseStatusJsonKey.ID, ordinal = 4)
    @JsonProperty(value=ResponseStatusJsonKey.ID)
    private String id;

    @ApiModelProperty(value="日期时间")
    @JSONField(name = ResponseStatusJsonKey.LOCAL_TIME, format = DateUtil.yyyyMMddHHmmss_style, ordinal = 5)
    @JsonProperty(value=ResponseStatusJsonKey.LOCAL_TIME)
    private Date localTime;

    public ResponseStatus() {

    }

    public ResponseStatus(String requestURL, int statusCode, String statusString, String id) {
        this.requestURL = requestURL;
        this.statusCode = statusCode;
        this.statusString = statusString;
        this.id = id;
        this.localTime = new Date();
    }
    
    public ResponseStatus(String requestURL, ResponseStatusType statusType, String id) {
        this.requestURL = requestURL;
        this.statusCode = statusType.getStatusCode();
        this.statusString = statusType.getStatusDes();
        this.id = id;
        this.localTime = new Date();
    }

    public ResponseStatus(String requestURL, ResponseStatusType statusType, String statusString, String id) {
        this.requestURL = requestURL;
        this.statusCode = statusType.getStatusCode();
        this.statusString = statusString;
        this.id = id;
        this.localTime = new Date();
    }
}