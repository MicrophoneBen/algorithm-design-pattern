package com.other.updown.service;

import com.other.updown.domain.response.ResponseStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhangbingquan
 * @desc 图片上传服务层
 * @time 2019-09-24 23:54
 */
public interface ImageUploadService{

    ResponseStatus importPlatformExcelFile(MultipartFile file, HttpServletRequest request);
}
