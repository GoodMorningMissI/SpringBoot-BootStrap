package com.example.labtest.dao;

import com.example.labtest.domain.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score,Long> {
    Score findByCourseno(String no);
    Score deleteByCoursenoAndStuno(String courseno,String stuno);
    Score findByCoursenoAndStuno(String courseno,String stuno);
}
