package com.example.labtest.service.impl;

import com.example.labtest.dao.StudentScoreView;
import com.example.labtest.domain.StudentScore;
import com.example.labtest.service.StudentScoreViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentScoreViewImplService implements StudentScoreViewService {
    @Autowired
    StudentScoreView studentScoreView;

    public List<StudentScore> findByno(String no){
        return studentScoreView.findByNo(no);
    };
    public StudentScore findByNoAndCoursename(String no,String coursename){
        return studentScoreView.findByNoAndCoursename(no,coursename);
    };




}
