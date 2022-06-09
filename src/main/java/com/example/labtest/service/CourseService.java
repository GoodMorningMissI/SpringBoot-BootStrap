package com.example.labtest.service;

import com.example.labtest.dao.CourseRepository;
import com.example.labtest.domain.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    public Course findbycoursename(String name);
    public List<Course> findByProcno(String procno);
    public List<Course> findAll();
    public Course findByCourseno(String courseno);
    public void insert(Course course);
}
