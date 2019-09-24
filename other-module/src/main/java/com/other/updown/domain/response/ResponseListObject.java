package com.other.updown.domain.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 批量查询接口分页返回List
 * 
 */
@ApiModel(description = "ResponseListObject")
@Data
public class ResponseListObject<T> {
    
    /**
     * 接口调用状态
     */
    @ApiModelProperty(value="接口调用状态")
    @JsonProperty(value="ResponseStatusObject")
    @JSONField(name="ResponseStatusObject")
    private ResponseStatus response;
    
    /**
     *分页查询结果
     */
    @ApiModelProperty(value="查询结果")
    @JsonProperty(value="ResponseResult")
    @JSONField(name="ResponseResult")
    private RecordInfo<T> recordInfo;
    
    public ResponseListObject(){}
    
    public ResponseListObject(ResponseStatus response) {
        this.response = response;
    }
    public ResponseListObject(ResponseStatus response, RecordInfo<T> recordInfo) {
        this.response = response;
        this.recordInfo = recordInfo;
    }
}
