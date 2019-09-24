package com.other.updown.utils;

import com.other.updown.domain.dto.ImagesUpload;
import org.jxls.common.Context;
import org.jxls.expression.JexlExpressionEvaluator;
import org.jxls.transform.Transformer;
import org.jxls.transform.poi.PoiTransformer;
import org.jxls.util.JxlsHelper;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * jxls2.0导出工具类
 *
 * @author huangyujie
 * @since 2019/4/23 10:32
 */
public class JxlsUtil {

    /**
     * 导出文件
     *
     * @param is
     * @param os
     * @param model
     * @throws IOException
     */
    public static void exportExcel(InputStream is, OutputStream os, Map<String, Object> model) throws IOException {
        Context context = PoiTransformer.createInitialContext();
        if (model != null) {
            for (String key : model.keySet()) {
                context.putVar(key, model.get(key));
            }
        }

        JxlsHelper jxlsHelper = JxlsHelper.getInstance();
        Transformer transformer = jxlsHelper.createTransformer(is, os);

        //获得配置
        JexlExpressionEvaluator evaluator = (JexlExpressionEvaluator) transformer.getTransformationConfig()
                .getExpressionEvaluator();

        //设置静默模式，不报警告
        //evaluator.getJexlEngine().setSilent(true);

        //函数强制，自定义功能
        Map<String, Object> funcs = new HashMap<String, Object>();
        funcs.put("utils", new JxlsUtil());    //添加自定义功能
        evaluator.getJexlEngine().setFunctions(funcs);

        //必须要这个，否者表格函数统计会错乱
        jxlsHelper.setUseFastFormulaProcessor(false).processTemplate(context, transformer);
    }

    /**
     * 根据文件模板地址,导出文件
     *
     * @param templatePath
     * @param os
     * @param model
     * @throws Exception
     */
    public static void exportExcel(String templatePath, OutputStream os, Map<String, Object> model) throws Exception {
        File template = getTemplate(templatePath);
        if (template != null) {
            exportExcel(new FileInputStream(template), os, model);
        } else {
            throw new Exception("Excel 模板未找到。");
        }
    }

    /**
     * 获取jxls文件模板
     *
     * @param path
     * @return
     */
    public static File getTemplate(String path) {
        File template = new File(path);
        if (template.exists()) {
            return template;
        }

        return null;
    }
    // 日期格式化
    public String dateFmt(Date date, String fmt) {
        if (date == null) {
            return "";
        }
        try {
            SimpleDateFormat dateFmt = new SimpleDateFormat(fmt);
            return dateFmt.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 测试
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // 模板路径和输出流
        String templatePath = "E:/templates.xls";
        OutputStream os = new FileOutputStream("E:/out.xls");
        // 定义一个Map，往里面放入要在模板中显示数据
        Map<String, Object> model = new HashMap<String, Object>();
        List<ImagesUpload> platformList = new ArrayList<>();
        ImagesUpload rsPlatform = new ImagesUpload();
        rsPlatform.setImageId(100002);
        platformList.add(rsPlatform);
        model.put("platformList", platformList);
        //调用之前写的工具类，传入模板路径，输出流，和装有数据Map
        JxlsUtil.exportExcel(templatePath, os, model);
        os.close();
        System.out.println("完成");
    }
}