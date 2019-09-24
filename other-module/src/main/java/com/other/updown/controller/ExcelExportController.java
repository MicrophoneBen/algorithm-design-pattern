package com.other.updown.controller;

import com.other.updown.domain.dto.ImagesUpload;
import com.other.updown.domain.response.ResponseStatus;
import com.other.updown.domain.response.ResponseStatusObject;
import com.other.updown.domain.vo.JxlsExcelView;
import com.other.updown.service.ImageUploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangbingquan
 * @desc Excel模板导出类
 * @time 2019-09-24 23:39
 */
@RestController
@Slf4j
@RequestMapping("excel")
@Api(value = "excel导出接口", tags = "Excel导出接口")
public class ExcelExportController {
    @Autowired
    ImageUploadService platformService;

    /**
     * 导出导入模板列表
     *
     * @return
     */
    @ApiOperation(value = "下载导入模板",notes = "下载导入模板")
    @GetMapping("/getImportTemplate")
    public ModelAndView exportImportTemplate(){
        log.debug("开始下载平台管理Excel模板");
        long startTime = System.currentTimeMillis();
        log.info("平台Excel模板下载成功，耗时 {}ms", System.currentTimeMillis() - startTime);
        return new ModelAndView(new JxlsExcelView("platformImport.xls", "平台管理导入模板", true), new HashMap<>());
    }
    /**
     * 批量导出资源平台列表
     *
     * @return
     */
    @ApiOperation(value = "批量导出资源平台列表",notes = "批量导出资源平台列表")
    @GetMapping(value = "/getPlatformExport")
    public ModelAndView exportPlatform(@RequestParam(required = true, value = "IDList") String idString, HttpServletRequest request){
        log.debug("开始批量导出资源平台列表");
        long startTime = System.currentTimeMillis();
//        List<ImagesUpload> platformList = platformService.queryToExport(idString);
        List<ImagesUpload> platformList = new ArrayList<>();
        // 模板路径和输出流
        Map<String, Object> dataMap = new HashMap<>(16);
        dataMap.put("platformList", platformList);
        log.info("资源平台列表Excel批量导出成功，耗时 {}ms", System.currentTimeMillis() - startTime);
        return new ModelAndView(new JxlsExcelView("platformExport.xls", "资源平台导出文件"), dataMap);
    }

    /**
     * 批量导入资源平台列表
     * @param file 导入文件
     * @return
     */
    @ApiOperation(value = "批量导入资源平台列表",notes = "批量导入资源平台列表")
    @PostMapping(value = "/importPlatformExcelFile")
    public ResponseStatusObject importFile(MultipartFile file, HttpServletRequest request) throws Exception {
        log.debug("开始批量导入资源平台列表");
        long startTime = System.currentTimeMillis();
        ResponseStatus responseStatus = platformService.importPlatformExcelFile(file, request);
        log.info("平台Excel模板导入成功，耗时 {}ms", System.currentTimeMillis() - startTime);
        ResponseStatusObject statusObj = new ResponseStatusObject();
        statusObj.setResponseStatusObject(responseStatus);
        return statusObj;
    }
}
