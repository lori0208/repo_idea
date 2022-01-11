package com.zxz.service.impl;

import com.zxz.dao.CourseMapper;
import com.zxz.domain.Course;
import com.zxz.domain.CourseVo;
import com.zxz.domain.Teacher;
import com.zxz.service.CourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName CourseServiceImpl
 * @Description TODO
 * @Creat 2021-12-30  15:04:20
 */

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> findByCondition(CourseVo courseVo) {

        List<Course> courseList = courseMapper.findByCondition(courseVo);

        return courseList;
    }

    @Override
    public void saveCourseOrTeacher(CourseVo courseVo) {

        // 创建 course
        Course course = new Course();
        // 封装 course
        BeanUtils.copyProperties(courseVo,course);

        // 补全信息
        Date date = new Date();
        course.setCreateTime(date);
        course.setUpdateTime(date);
        course.setIsDel(0);

        // 保存 course
        courseMapper.saveCourse(course);

        // 获取 courseId
        int courseId = course.getId();

        // 创建 teacher
        Teacher teacher = new Teacher();
        // 封装 teacher
        BeanUtils.copyProperties(courseVo,teacher);
        // 补全信息
        teacher.setCourseId(courseId);
        teacher.setCreateTime(date);
        teacher.setUpdateTime(date);
        teacher.setIsDel(0);

        // 保存 teacher
        courseMapper.saveTeacher(teacher);
    }

    @Override
    public CourseVo findCourseById(Integer id) {

        CourseVo courseVo = courseMapper.findCourseById(id);
        return courseVo;
    }

    @Override
    public void updateCourseOrTeacher(CourseVo courseVo) {

        /* 更新 course */

        // 封装 course
        Course course = new Course();
        BeanUtils.copyProperties(courseVo,course);
        // 补全信息
        Date date = new Date();
        course.setUpdateTime(date);
        // 更新操作
        courseMapper.updateCourse(course);

        /* 更新 teacher */

        // 封装 course
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(courseVo,teacher);
        // 补全信息
        teacher.setUpdateTime(date);
        teacher.setCourseId(course.getId());
        // 更新操作
        courseMapper.updateTeacher(teacher);
    }

    @Override
    public void updateCourseStatus(int courseId, int status) {

        // 封装 course
        Course course = new Course();
        course.setId(courseId);
        course.setStatus(status);
        course.setUpdateTime(new Date());

        // 调用 dao
        courseMapper.updateCourseStatus(course);
    }

}
