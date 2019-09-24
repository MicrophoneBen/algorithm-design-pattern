package com.other.updown.domain.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.other.updown.domain.jsonkey.ResponseStatusJsonKey;
import com.other.updown.domain.response.ResponseStatus;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ResponseStatusObject{
    
    @ApiModelProperty(value = "应答状态对象")
    @JsonProperty(value = ResponseStatusJsonKey.RESPONSE_STATUS_OBJECT)
    @JSONField(name = ResponseStatusJsonKey.RESPONSE_STATUS_OBJECT)
    public ResponseStatus responseStatusObject;

    public ResponseStatusObject() {
    }

    public ResponseStatusObject(ResponseStatus responseStatusObject) {
        this.responseStatusObject = responseStatusObject;
    }
}