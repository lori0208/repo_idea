package com.zxz.service.impl;

import com.zxz.dao.CourseContentMapper;
import com.zxz.domain.Course;
import com.zxz.domain.CourseLesson;
import com.zxz.domain.CourseSection;
import com.zxz.service.CourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName CourseContentServiceImpl
 * @Description TODO
 * @Creat 2022-01-04  08:21:03
 */
@Service
public class CourseContentServiceImpl implements CourseContentService {

    @Autowired
    private CourseContentMapper courseContentMapper;

    @Override
    public List<CourseSection> findSectionAndLessonByCourseId(Integer courseId) {

        List<CourseSection> sectionList = courseContentMapper.findSectionAndLessonByCourseId(courseId);
        return sectionList;
    }

    @Override
    public Course findCourseByCourseId(Integer courseId) {
        Course course = courseContentMapper.findCourseByCourseId(courseId);
        return course;
    }

    @Override
    public void saveSection(CourseSection courseSection) {
        // 补全信息
        Date date = new Date();
        courseSection.setCreateTime(date);
        courseSection.setUpdateTime(date);

        // 调用 courseContentMapper 方法
        courseContentMapper.saveSection(courseSection);
    }

    @Override
    public void updateSection(CourseSection courseSection) {

        // 补全信息
        Date date = new Date();
        courseSection.setUpdateTime(date);

        // 调用 courseContentMapper 方法
        courseContentMapper.updateSection(courseSection);
    }

    @Override
    public void updateSectionStatus(Integer id, Integer status) {

        // 封装 courseSection
        CourseSection courseSection = new CourseSection();
        courseSection.setId(id);
        courseSection.setStatus(status);
        // 补全信息
        Date date = new Date();
        courseSection.setUpdateTime(date);

        // 调用 courseContentMapper 方法
        courseContentMapper.updateSectionStatus(courseSection);
    }

    @Override
    public void saveLesson(CourseLesson courseLesson) {

        // 补全信息
        Date date = new Date();
        courseLesson.setCreateTime(date);
        courseLesson.setUpdateTime(date);
        courseLesson.setIsDel(0);

        // 调用 courseContentMapper 方法
        courseContentMapper.saveLesson(courseLesson);
    }
}
