package com.other.updown.domain.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.other.updown.domain.BaseEntity;
import com.other.updown.domain.jsonkey.RecordInfoJsonKey;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 分页对象
 * 
 * @author cxb
 * @since 3.0.3
 * @version 2019年4月29日
 */
@Data
public class RecordInfo<T> extends BaseEntity {
    
    private static final long serialVersionUID = 1192590006571586466L;

    @ApiModelProperty(value="开始记录数")
    @JsonProperty(value= RecordInfoJsonKey.RECORD_START_NO)
    @JSONField(name=RecordInfoJsonKey.RECORD_START_NO, ordinal=1)
    private Long recordStartNo;
    
    @ApiModelProperty(value="返回记录数")
    @JsonProperty(value=RecordInfoJsonKey.RETURN_NUM)
    @JSONField(name=RecordInfoJsonKey.RETURN_NUM, ordinal=2)
    private Integer returnNum;
    
    @ApiModelProperty(value="总记录数")
    @JsonProperty(value=RecordInfoJsonKey.TOTAL_NUM)
    @JSONField(name=RecordInfoJsonKey.TOTAL_NUM, ordinal=3)
    private Long totalNum;
    
    @ApiModelProperty(value="查询结果对象列表")
    @JsonProperty(value="Records")
    @JSONField(name="Records")
    private List<T> list;
    
    public RecordInfo() {
        
    }

    public RecordInfo(long recordStartNo, Integer returnNum, Long totalNum, List<T> list) {
        this.recordStartNo = recordStartNo;
        this.returnNum = returnNum;
        this.totalNum = totalNum;
        this.list = list;
    }

}
