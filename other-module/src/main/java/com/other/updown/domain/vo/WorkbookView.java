package com.other.updown.domain.vo;

import lombok.Data;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.Map;

/**
 * poi的Workbook导出类
 *
 * @author hyj
 * 2019/04/24 14:22:43
 */
@Data
public class WorkbookView extends AbstractView {
    /** 模板名称 */
    Workbook workbook;

    /** 文件名 */
    String fileName;

    /**
     * 构造函数
     * @param workbook
     * @param fileName
     */
    public WorkbookView(Workbook workbook, String fileName){
        this.workbook = workbook;
        this.fileName = fileName;
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
        // 设置返回结果
        response.setHeader("Content-Disposition", "attachment;filename*=UTF-8''" + URLEncoder.encode(fileName,"UTF-8"));
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        workbook.write(response.getOutputStream());
        workbook.close();
    }
}