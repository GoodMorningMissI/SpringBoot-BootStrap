package com.example.labtest.dao;

import com.example.labtest.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Long> {
    public Course findByCoursename(String coursename);
    public List<Course> findByProcno(String procno);
    public List<Course> findAll();
    public Course findByCourseno(String courseno);
}
