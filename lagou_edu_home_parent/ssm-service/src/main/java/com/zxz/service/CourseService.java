package com.zxz.service;

import com.zxz.domain.Course;
import com.zxz.domain.CourseVo;

import java.util.List;

/**
 * @ClassName CourseService
 * @Description TODO
 * @Creat 2021-12-30  15:03:44
 */
public interface CourseService {

    /*
        根据条件查询 course 信息
    */
    public List<Course> findByCondition(CourseVo courseVo);

    /*
        新建课程
    */
    public void saveCourseOrTeacher(CourseVo courseVo);

    /*
        课程信息回显 （根据 id 查询课程信息以及关联的讲师信息）
    */
    public CourseVo findCourseById(Integer id);

    /*
        更新课程，讲师信息
    */
    public void updateCourseOrTeacher(CourseVo courseVo);

    /*
        更新 课程状态信息
    */
    public void updateCourseStatus(int courseId,int status);
}

