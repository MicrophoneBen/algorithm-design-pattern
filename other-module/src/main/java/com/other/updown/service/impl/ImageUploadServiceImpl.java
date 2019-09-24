package com.other.updown.service.impl;

import com.other.updown.domain.response.ResponseStatus;
import com.other.updown.service.ImageUploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhangbingquan
 * @desc 业务逻辑层实现类
 * @time 2019-09-24 23:55
 */
@Service
public class ImageUploadServiceImpl implements ImageUploadService {
    @Override
    public ResponseStatus importPlatformExcelFile(MultipartFile file, HttpServletRequest request) {
        return null;
    }
    /***
     *  @param   file, request
     *  @return com.suntek.resource.manager.camera.domain.response.ResponseStatus
     *  导入Excel文件后批量导入数据库
     **/
/*    @Transactional(rollbackFor = ValidateErrorException.class, noRollbackFor = ValidateWarnException.class)
    @Override
    public ResponseStatus importPlatformExcelFile(MultipartFile file, HttpServletRequest request) throws Exception {
        Sheet sheet = ExcelUtil.getWorkbook(file).getSheetAt(0);
        // 解析excel数据,参数字段传空就是不获取数据
        //自增长ID 平台编码 平台名称 平台类型 行政区划 平台厂商 建设单位  管理员姓名  管理员电话  承建单位  维护单位  接入网络 平台IP  平台端口 平台密码 创建时间 更新时间
        String[] paramsArray = {"", "platformFlag", "platformName", "platformType", "orgCode", "platformManufacturer",
                "constructionUnit", "adminName", "adminPhone", "constructionCompany", "maintainCompany", "accessNetwork", "platformIpAddress",
                "platformPort", "platformPassword", "", ""};
        String[] typeArray = {"NULL", "S", "S", "I", "S", "I", "S", "S", "S", "S", "S", "I", "S", "I", "S", "NULL", "NULL"};
        List<Map<String, Object>> dataMapList = ExcelUtil.readExcelMsg(sheet, paramsArray, typeArray, 0, 2);
        // 对象转为bean
        List<ImagesUpload> platformList = ObjectUtil.mapsToObjects(dataMapList, ImagesUpload.class);
        log.debug("从excel中读取的用户行数为={}", platformList.size());
        Map<String, Object> importStatus = new HashMap<>();
        List<ImagesUpload> validPlatformFailedList = ValidMessageUtil.validatePlatformParams(platformList);
        importStatus.put("failCount", validPlatformFailedList.size());
        //Excel导入失败的数据处理，放到KafKa或者重新生成一个文件
        platformList.removeAll(validPlatformFailedList);
        importStatus.put("successCount", platformList.size());
        if (CollectionUtil.isNotEmpty(platformList)) {
            //判断导入的数据中平台编号是否有冲突
            List<String> platformFlagList = platformList.stream().map(ImagesUpload::getPlatformFlag).collect(Collectors.toList());

            this.batchInsertPlatform(platformList);
        }else {
            return new ResponseStatus(request.getRequestURI(), ResponseStatusType.SUCCESS_200,
                    "平台Excel模板上传成功，成功导入数据条数 : " + importStatus.get("successCount") + " 失败数据条数 ： " + importStatus.get("failCount"));
        }
        return new ResponseStatus(request.getRequestURI(),ResponseStatusType.SUCCESS_200,
                "平台Excel模板导入成功，成功导入数据条数 : " + importStatus.get("successCount") + " 失败数据条数 ： " + importStatus.get("failCount"));
    }*/
}
