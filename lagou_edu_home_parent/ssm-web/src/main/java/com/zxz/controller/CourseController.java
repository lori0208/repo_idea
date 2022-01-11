package com.zxz.controller;

import com.zxz.domain.Course;
import com.zxz.domain.CourseVo;
import com.zxz.domain.ResponseResult;
import com.zxz.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName CourseController
 * @Description TODO
 * @Creat 2021-12-30  15:09:37
 */
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // 根据条件查询 course
    @RequestMapping("/findCourseByCondition")
    public ResponseResult findCourseByCondition(@RequestBody CourseVo courseVo){

        List<Course> courseList = courseService.findByCondition(courseVo);

        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        responseResult.setState(200);
        responseResult.setMessage("请求成功");
        responseResult.setContent(courseList);

        return responseResult;
    }

    // 图片上传
    @RequestMapping("/courseUpload")
    public ResponseResult fileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {

        // 1,判断文件是否为空
        if (file.isEmpty()){
            // 文件为空，抛出异常
            throw  new RuntimeException();
        }
        //2.获取项目部署路径
        //  realPath = /Users/huinan/develop_tools/apache-tomcat-8.5.72/webapps/ssm_web/
        String realPath = request.getServletContext().getRealPath("/");
        System.out.println("realPath = " + realPath);

        //  webappPath = /Users/huinan/develop_tools/apache-tomcat-8.5.72/webapps/
        String webappPath = realPath.substring(0,realPath.indexOf("ssm_web"));
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

        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        responseResult.setState(200);
        responseResult.setMessage("请求成功");
        responseResult.setContent(map);

        return responseResult;
    }

    // 保存，修改课程信息
    @RequestMapping("/saveOrUpdateCourse")
    public ResponseResult saveOrUpdateCourse(@RequestBody CourseVo courseVo){

        // 创建 响应结果 responseResult
        ResponseResult responseResult = new ResponseResult();

        if (courseVo.getId() == null){
            // 没有 传递 courseId ，新增操作
            courseService.saveCourseOrTeacher(courseVo);
            responseResult.setMessage("新增成功");
        } else {
            // 传递 courseId ，更新操作
            courseService.updateCourseOrTeacher(courseVo);
            responseResult.setMessage("更新成功");
        }

        responseResult.setSuccess(true);
        responseResult.setState(200);
        responseResult.setContent(null);

        return responseResult;
    }

    /*
        课程信息回显 （根据 id 查询课程信息以及关联的讲师信息）
    */
    @RequestMapping("/findCourseById")
    public ResponseResult findCourseById(Integer id){

        CourseVo courseVo = courseService.findCourseById(id);

        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        responseResult.setState(200);
        responseResult.setMessage("请求成功");
        responseResult.setContent(courseVo);

        return responseResult;
    }
    /*
        修改课程状态
    */
    @RequestMapping("/updateCourseStatus")
    public ResponseResult updateCourseStatus(@RequestParam("id") Integer courseId,@RequestParam("status")Integer status){

        // 调用 service
        courseService.updateCourseStatus(courseId,status);

        // 响应结果
        HashMap<String, Object> map = new HashMap<>();
        map.put("status",status);

        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        responseResult.setState(200);
        responseResult.setMessage("请求成功");
        responseResult.setContent(map);

        return responseResult;
    }

}
