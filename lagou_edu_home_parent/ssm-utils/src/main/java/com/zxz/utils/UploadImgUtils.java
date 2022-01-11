package com.zxz.utils;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName UploadImgUtils
 * @Description TODO
 * @Creat 2022-01-04  23:15:14
 */
public class UploadImgUtils {

    // 图片上传
    public static Map fileUpload(MultipartFile file, HttpServletRequest request) throws IOException {

        // 1,判断文件是否为空
        if (file.isEmpty()){
            // 文件为空，抛出异常
            throw  new RuntimeException();
        }
        //2.获取项目部署路径
        //  realPath = /Users/huinan/develop_tools/apache-tomcat-8.5.72/webapps/ssm-web/
        String realPath = request.getServletContext().getRealPath("/");
        System.out.println("realPath = " + realPath);

        //  webappPath = /Users/huinan/develop_tools/apache-tomcat-8.5.72/webapps/
        String webappPath = realPath.substring(0,realPath.indexOf("ssm-web"));
        System.out.println("webappPath = " + webappPath);

        //3.获取原文件名
        // 张飞.jpg
        String originalFilename = file.getOriginalFilename();

        //4.新文件名
        // 123237867364.jpg
        String newFilename = System.currentTimeMillis() + originalFilename.substring(originalFilename.lastIndexOf("."));

        //5.上传文件
        String uploadPath = webappPath + "upload//";

        File filePath = new File(uploadPath,newFilename);

        //如果目录不存在就创建目录
        if (!filePath.getParentFile().exists()){
            filePath.getParentFile().mkdirs();
            System.out.println("创建目录 ：" + filePath);
        }
        // 将 文件 上传到 filePath 目录中
        file.transferTo(filePath);

        HashMap<String, Object> map = new HashMap<>();
        map.put("fileName",newFilename);
        map.put("filePath","http://localhost:8080/upload/"+newFilename);

        return map;
    }
}
