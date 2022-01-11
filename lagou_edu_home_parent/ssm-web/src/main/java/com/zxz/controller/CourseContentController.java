package com.zxz.controller;

import com.zxz.domain.*;
import com.zxz.service.CourseContentService;
import com.zxz.service.PromotionAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName CourseContentController
 * @Description TODO
 * @Creat 2022-01-04  08:24:56
 */
@RestController // @Controller + @ResponseBody
@RequestMapping("/courseContent")
public class CourseContentController {

    @Autowired
    private CourseContentService courseContentService;

    @RequestMapping("/findSectionAndLesson")
    public ResponseResult findSectionAndLessonByCourseId(Integer courseId){

        List<CourseSection> sectionList = courseContentService.findSectionAndLessonByCourseId(courseId);

        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        responseResult.setState(200);
        responseResult.setMessage("请求成功");
        responseResult.setContent(sectionList);

        return responseResult;
    }
    /*
        根据 courseID 查询 课程信息
    */
    @RequestMapping("/findCourseByCourseId")
    public ResponseResult findCourseByCourseId(Integer courseId){

        Course course = courseContentService.findCourseByCourseId(courseId);

        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        responseResult.setState(200);
        responseResult.setMessage("请求成功");
        responseResult.setContent(course);

        return responseResult;
    }

    /*
       新增，修改 章节信息
    */
    @RequestMapping("/saveOrUpdateSection")
    public ResponseResult saveOrUpdateSection(@RequestBody CourseSection courseSection){

        if (courseSection.getId() != null){
            // 修改
            courseContentService.updateSection(courseSection);
        } else {
            // 新增
            courseContentService.saveSection(courseSection);
        }

        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        responseResult.setState(200);
        responseResult.setMessage("请求成功");
        responseResult.setContent(null);

        return responseResult;
    }

    /*
      修改章节状态
    */
    @RequestMapping("/updateSectionStatus")
    public ResponseResult updateSectionStatus(@RequestParam("id") Integer id, @RequestParam("status") Integer status){

        courseContentService.updateSectionStatus(id,status);

        HashMap<String, Object> map = new HashMap<>();
        map.put("status",status);

        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        responseResult.setState(200);
        responseResult.setMessage("请求成功");
        responseResult.setContent(map);

        return responseResult;
    }

    /*
       新增课时信息
    */
    @RequestMapping("/saveLesson")
    public ResponseResult saveOrUpdateLesson(@RequestBody CourseLesson courseLesson){

        System.out.println("saveOrUpdateLesson...");

        if (courseLesson.getId() != null){
            // 修改

        } else {
            // 新增
            courseContentService.saveLesson(courseLesson);
        }

        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        responseResult.setState(200);
        responseResult.setMessage("请求成功");
        responseResult.setContent(null);

        return responseResult;
    }




}
