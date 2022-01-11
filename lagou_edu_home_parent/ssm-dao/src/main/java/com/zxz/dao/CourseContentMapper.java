package com.zxz.dao;

import com.zxz.domain.Course;
import com.zxz.domain.CourseLesson;
import com.zxz.domain.CourseSection;

import java.util.List;

/**
 * @ClassName CourseContentMapper
 * @Description TODO
 * @Creat 2022-01-04  08:06:40
 */
public interface CourseContentMapper {
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
    public void updateSectionStatus(CourseSection courseSection);

    /*
       新增课时信息
    */
    public void saveLesson(CourseLesson courseLesson);

}
