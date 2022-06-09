package com.example.labtest.service.impl;

import com.example.labtest.dao.CourseRepository;
import com.example.labtest.domain.Course;
import com.example.labtest.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseImplService implements CourseService {
    @Autowired
    CourseRepository courseRepository;
    public Course findbycoursename(String name){
        return courseRepository.findByCoursename(name);
    };
    public List<Course> findByProcno(String procno){
        return courseRepository.findByProcno(procno);
    };
    public List<Course> findAll(){
        return courseRepository.findAll();

    };
    public Course findByCourseno(String courseno){
        return courseRepository.findByCourseno(courseno);
    };
    public void insert(Course course){
        courseRepository.save(course);
    };
}
