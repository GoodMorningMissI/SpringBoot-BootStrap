package com.example.labtest.service;

import com.example.labtest.domain.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentServiceTest {
    @Autowired
    StudentService studentService;


    @Test
    void findAll() {
    }

//    @Test
//    void insert() {
//        Student student = new Student();
//        student.setId(2001909090L);
//        student.setName("钱八");
//        student.setPassword("00000000");
//        student.setSex("男");
//        student.setScore(88);
//
//        Student student1=studentService.insert(student);
//        assertNotNull(student.getId());
//    }

//    @Test
//    void update() {
//        Student student=studentService.getById(2019131312L);
//        student.setScore(150);
//        studentService.update(student);
//    }

//    @Test
//    void getById() {
//        Student student=studentService.getById(1L);
//        System.out.println(student.getNo());
//        System.out.println(student.getName());
//        System.out.println(student.getPassword());
//        System.out.println(student.getSex());
//        System.out.println(student.getScore());
//    }

//    @Test
//    void delete() {
//        Student student=studentService.getById(2019131312L);
//        studentService.delete(student);
//    }

    @Test
    void findByname() {
        List<Student> students=studentService.findByName("黄培");
        System.out.println(students);
    }

    @Test
    public void filterByName(){
        Student student=new Student();
//        student.setName("李");
        student.setNo("2019");
        Sort sort=Sort.by(Sort.Direction.DESC,"id");
        Pageable pageable= PageRequest.of(0,10,sort);

        ExampleMatcher matcher=ExampleMatcher.matching()
                .withMatcher("no",ExampleMatcher.GenericPropertyMatchers.contains());
        Example<Student> example =Example.of(student,matcher);

        //Example<Student> example=Example.of(student);

        Page<Student> studentPage=studentService.findAll(example,pageable);
        System.out.println(studentPage);
    }
}