package com.example.labtest.dao;

import com.example.labtest.domain.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface  StudentRepository extends JpaRepository<Student,Long> {
//    public List<Student> findByNameLikeAndAgeLessThan(String name,Integer age);
//    @Query("from student_table o where o.age = (select max(age))")

    List<Student> findByName(String name);
    Page<Student> findByNameLike(String name, Pageable pageable);
    public List<Student> findByNoAndPassword(String no,String password);
    public Student findByNo(String no);
}
