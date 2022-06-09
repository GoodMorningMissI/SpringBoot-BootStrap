package com.example.labtest.domain;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "student_score")
@Data
public class StudentScore {
    @Id
    private Long id;

    @Column
    private String no;

    @Column
    private String procno;

    @Column
    private String courseno;

    @Column
    private  Float scoreusual;

    @Column
    private  Float scorefinal;

    @Column
    private  Float scoremakeup;

    @Column
    private  String coursename;

    @Column
    private Float credit;

    @Column
    private String procname;

}
