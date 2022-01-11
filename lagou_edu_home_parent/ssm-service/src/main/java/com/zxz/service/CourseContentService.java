package com.zxz.service;

import com.zxz.domain.Course;
import com.zxz.domain.CourseLesson;
import com.zxz.domain.CourseSection;

import java.util.List;

/**
 * @ClassName CourseContentService
 * @Description TODO
 * @Creat 2022-01-04  08:20:29
 */
public interface CourseContentService {
    /*
        根据课程id 查询关联的课时信息和章节信息
     */
    public List<CourseSection> findSectionAndLessonByCourseId(Integer courseId);

    /*
        根据 courseID 查询 课程信息
    */
    public Course findCourseByCourseId(Integer courseId);

    /*
       新增章节信息
    */
    public void saveSection(CourseSection courseSection);

    /*
       修改章节信息
    */
    public void updateSection(CourseSection courseSection);

    /*
      修改章节状态
    */
    public void updateSectionStatus(Integer id, Integer status);

    /*
       新增课时信息
    */
    public void saveLesson(CourseLesson courseLesson);
}
