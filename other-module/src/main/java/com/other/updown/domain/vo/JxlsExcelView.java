package com.other.updown.domain.vo;

import com.other.updown.utils.JxlsUtil;
import lombok.Data;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Map;

/**
 * jxls导出视图类
 *
 * @author hyj
 * 2019/04/24 14:22:43
 */
@Data
public class JxlsExcelView extends AbstractView {
    /** 模板名称 */
    String templateName;

    /** 文件名 */
    String fileName;

    /** 文件后缀 */
    String filePostfix;

    /** true:导出导入模板,false:导出正常模板 */
    boolean isImport;

    /**
     * 构造函数
     * @param templateName 模板名称
     * @param fileName 文件名
     */
    public JxlsExcelView(String templateName, String fileName){
        this.templateName = templateName;
        this.fileName = fileName;
        this.filePostfix = templateName.substring(templateName.lastIndexOf("."));
        this.isImport = false;
    }


    /**
     * 构造函数
     * @param templateName 模板名称
     * @param fileName 文件名
     * @param isImport true:导出导入模板,false:导出正常模板
     */
    public JxlsExcelView(String templateName, String fileName, Boolean isImport){
        this.templateName = templateName;
        this.fileName = fileName;
        this.filePostfix = templateName.substring(templateName.lastIndexOf("."));
        this.isImport = isImport;
    }

    /**
     * 导出文件处理
     * @param model    数据
     * @param request  请求
     * @param response 返回值
     * @throws Exception
     */
    protected void renderMergedOutputModel(Map<String, Object> model,
                                           HttpServletRequest request,
                                           HttpServletResponse response) throws Exception {
        String template = "";

        // 如果是导入模板,使用导入模板的目录
        if(isImport){
            template = "excelImportTemplate";
        }else{
            template = "excelExportTemplate";
        }

        // 获取模板文件的文件流
        String filePath = "static/"+ template + "/" + templateName;
        InputStream in = new ClassPathResource(filePath).getInputStream();

        // 设置返回结果
        response.setHeader("Content-Disposition",
                "attachment;filename*=UTF-8''" + URLEncoder.encode(fileName + filePostfix,"UTF-8"));
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setCharacterEncoding("UTF-8");

        // 导出文件
        JxlsUtil.exportExcel(in, response.getOutputStream(), model);

    }
}