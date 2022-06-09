package com.example.labtest.service.impl;

import com.example.labtest.dao.ScoreRepository;
import com.example.labtest.domain.Score;
import com.example.labtest.domain.Student;
import com.example.labtest.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreImplService implements ScoreService {
    @Autowired
    ScoreRepository scoreRepository;


    public Score insert(Score score){
        return scoreRepository.save(score);
    }


    public Score update(Score score){
        return scoreRepository.save(score);
    }
    public Score findbycourseno(String no){
        return scoreRepository.findByCourseno(no);
    };
    public Score deleteByCoursenoAndStuno(String courseno,String stuno){
        return scoreRepository.deleteByCoursenoAndStuno(courseno,stuno);
    };
    public Score findByCoursenoAndStuno(String courseno,String stuno){
        return scoreRepository.findByCoursenoAndStuno(courseno,stuno);
    };
    public void delete(Score score){
        scoreRepository.delete(score);
    };
}
