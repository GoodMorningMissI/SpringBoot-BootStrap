package com.example.labtest.dao;

import com.example.labtest.domain.Student;
import com.example.labtest.domain.StudentScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentScoreView extends JpaRepository<StudentScore,Long> {

//    @Query(value = "select * from student_score where student_score.no= no")
    public List<StudentScore> findByNo(String no);
    public StudentScore findByNoAndCoursename(String no,String coursename);

}
