package com.other.updown.domain.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.other.updown.domain.BaseEntity;
import com.other.updown.domain.jsonkey.ResponseStatusJsonKey;
import com.other.updown.domain.response.ResponseStatus;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 批量新增、删除、修改返回应答状态对象列表
 * 
 */
public class ResponseStatusListObject extends BaseEntity {
    
    private static final long serialVersionUID = -3481276775382188423L;
    
    @ApiModelProperty(value="应答状态对象列表")
    @JSONField(name = ResponseStatusJsonKey.RESPONSE_STATUS_LIST_OBJECT)
    @JsonProperty(value = ResponseStatusJsonKey.RESPONSE_STATUS_LIST_OBJECT)
    private Map<String , List<ResponseStatus>> subscribeListMap;
    
    public ResponseStatusListObject() {
        this.subscribeListMap = new HashMap<String, List<ResponseStatus>>();
    }
    
    public ResponseStatusListObject(List<ResponseStatus> list) {
        this();
        this.subscribeListMap.put(ResponseStatusJsonKey.RESPONSE_STATUS_OBJECT, list);
    }
    
    public void setList(List<ResponseStatus> list) {
        if (null == this.subscribeListMap) {
            this.subscribeListMap = new HashMap<String, List<ResponseStatus>>();
        }
        this.subscribeListMap.put(ResponseStatusJsonKey.RESPONSE_STATUS_OBJECT, list);
    }
    
    public void addResponseStatus(ResponseStatus response) {
        if (null == this.subscribeListMap) {
            this.subscribeListMap = new HashMap<String, List<ResponseStatus>>();
        }
        
        if (null == this.subscribeListMap.get(ResponseStatusJsonKey.RESPONSE_STATUS_OBJECT)) {
            List<ResponseStatus> list = new ArrayList<ResponseStatus>();
            this.subscribeListMap.put(ResponseStatusJsonKey.RESPONSE_STATUS_OBJECT, list);
        }
        
        this.subscribeListMap.get(ResponseStatusJsonKey.RESPONSE_STATUS_OBJECT).add(response);
    }
    
    public Map<String , List<ResponseStatus>> getSubscribeListMap() {
        return this.subscribeListMap;
    }
}