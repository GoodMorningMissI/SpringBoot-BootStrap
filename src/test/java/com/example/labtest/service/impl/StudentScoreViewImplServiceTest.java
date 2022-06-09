package com.example.labtest.service.impl;

import com.example.labtest.domain.StudentScore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentScoreViewImplServiceTest {
    @Autowired
    StudentScoreViewImplService studentScoreViewImplService;

    @Test
    void findbyno(){
        List<StudentScore> studentScores=studentScoreViewImplService.findByno("2019131312");
        System.out.println(studentScores);
    }

}