package com.other.updown.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Date;
import java.util.Iterator;

/**
 * @author zhangbingquan
 * @version 2019年09月18日
 * @since 2019年09月18日
 **/
@Slf4j
@Controller
public class FileUploadController {
    /*
     * 通过流的方式上传文件
     * @RequestParam("file") 将name=file控件得到的文件封装成CommonsMultipartFile 对象
     */
    @RequestMapping(value = "fileUpload1", method = RequestMethod.POST)
    public String  fileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        //注意上面要使用接口实现，MultipartFile，否则使用 CommonsMultipartFile 会报使用内部类StandardMultipartFile转换CommonsMultipartFile异常
        //用来检测程序运行时间
        long  startTime=System.currentTimeMillis();
        System.out.println("fileName："+file.getOriginalFilename());

        try {
            //获取输出流
            OutputStream os=new FileOutputStream("E:/"+new Date().getTime()+file.getOriginalFilename());
            //获取输入流 CommonsMultipartFile 中可以直接得到文件的流
            InputStream is=file.getInputStream();
            int temp;
            //一个一个字节的读取并写入
            while((temp=is.read())!=(-1))
            {
                os.write(temp);
            }
            os.flush();
            os.close();
            is.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        long  endTime=System.currentTimeMillis();
        System.out.println("方法一的运行时间："+ (endTime - startTime) +"ms");
        return "success.html";
    }
    /*
     * 采用file.Transto 来保存上传的文件
     */
    @RequestMapping(value = "fileUpload2", method = RequestMethod.POST)
    public String  fileUpload2(@RequestParam("file") MultipartFile file) throws IOException {
        long  startTime=System.currentTimeMillis();
        System.out.println("fileName："+file.getOriginalFilename());
        String path="E:/"+new Date().getTime()+file.getOriginalFilename();

        File newFile=new File(path);
        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        file.transferTo(newFile);
        long  endTime=System.currentTimeMillis();
        System.out.println("方法二的运行时间："+ (endTime - startTime) +"ms");
        return "success.html";
    }
    /*
     *采用spring提供的上传文件的方法
     */
    @RequestMapping(value = "springUpload3", method = RequestMethod.POST)
    public String  springUpload(HttpServletRequest request) throws IllegalStateException, IOException
    {
        long  startTime=System.currentTimeMillis();
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
                request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if(multipartResolver.isMultipart(request))
        {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
            //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();

            while(iter.hasNext())
            {
                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(file!=null)
                {
                    String path="E:/springUpload"+file.getOriginalFilename();
                    //上传
                    file.transferTo(new File(path));
                }

            }
        }
        long  endTime=System.currentTimeMillis();
        System.out.println("方法三的运行时间："+ (endTime - startTime) +"ms");
        return "success.html";
    }

    @GetMapping("/")
    public Object indexPage() {
        return "index.html";
    }

    @GetMapping("/home")
    public Object helloPage() {
        return "index.html";
    }

    @GetMapping("/hello")
    @ResponseBody
    public Object helloMyPage() {
        return "HelloWorld";
    }
}
