package com.zxz.dao;

import com.zxz.domain.Course;
import com.zxz.domain.CourseVo;
import com.zxz.domain.Teacher;

import java.util.List;

/**
 * @ClassName CourseMapper
 * @Description TODO
 * @Creat 2021-12-30  12:25:55
 */
public interface CourseMapper {

    /*
        根据条件查询 course 信息
    */
    public List<Course> findByCondition(CourseVo courseVo);

    /*
        新增 course
    */
    public void saveCourse(Course course);

    /*
        新增 teacher
    */
    public void saveTeacher(Teacher teacher);

    /*
        课程信息回显 （根据 id 查询课程信息以及关联的讲师信息）
    */
    public CourseVo findCourseById(Integer id);

    /*
        更新 course 信息
    */
    public void updateCourse(Course course);

    /*
        更新 teacher 信息
    */
    public void updateTeacher(Teacher teacher);

    /*
        更新 课程状态
    */
    public void updateCourseStatus(Course course);

}
