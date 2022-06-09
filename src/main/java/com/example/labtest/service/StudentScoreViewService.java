package com.example.labtest.service;

import com.example.labtest.dao.StudentScoreView;
import com.example.labtest.domain.StudentScore;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentScoreViewService {

    List<StudentScore> findByno(String no);
    public StudentScore findByNoAndCoursename(String no,String coursename);
}
