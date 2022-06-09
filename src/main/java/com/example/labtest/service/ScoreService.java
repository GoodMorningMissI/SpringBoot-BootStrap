package com.example.labtest.service;

import com.example.labtest.domain.Score;
import org.springframework.stereotype.Service;

@Service
public interface ScoreService {
    public Score insert(Score score);
    public Score update(Score score);
    public Score findbycourseno(String no);
    public Score deleteByCoursenoAndStuno(String courseno,String stuno);
    public Score findByCoursenoAndStuno(String courseno,String stuno);
    public void delete(Score score);
}
