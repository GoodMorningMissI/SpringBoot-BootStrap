package com.example.labtest.domain;

import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="score_table")
@Data
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseno;
    private String stuno;
    private Float scoreusual;
    private Float scorefinal;
    private Float scoremakeup;
}