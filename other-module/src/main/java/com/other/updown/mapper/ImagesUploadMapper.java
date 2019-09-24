package com.other.updown.mapper;

import com.other.updown.domain.dto.ImagesUpload;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ImagesUploadMapper {
    int deleteByPrimaryKey(Integer imageId);

    int insert(ImagesUpload record);

    ImagesUpload selectByPrimaryKey(Integer imageId);

    List<ImagesUpload> selectAll();

    int updateByPrimaryKey(ImagesUpload record);
}