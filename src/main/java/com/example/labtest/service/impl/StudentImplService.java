package com.example.labtest.service.impl;

import com.example.labtest.dao.StudentRepository;
import com.example.labtest.domain.Student;
import com.example.labtest.service.StudentService;
import jdk.nashorn.internal.ir.RuntimeNode;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentImplService implements StudentService {

    @Autowired
    StudentRepository studentRepository;
    public List<Student>findAll(){
        return studentRepository.findAll();
    }

    /**
     * 插入学生
     * @param student
     * @return
     */
    public Student insert(Student student){
        return studentRepository.save(student);
    }

    /**
     * 更新学生
     * @param student
     * @return
     */
    public Student update(Student student){
        return studentRepository.save(student);
    }

    /**
     * 查找学生
     * @param id
     * @return
     */
    public Student getById(Long id){
        Student student=studentRepository.findById(id).orElse(null);
        return student;
    }
    public List<Student> getByName(String name){
        List<Student> students=studentRepository.findByName(name);
        return students;
    }
    /**
     * 删除学生
     * @param student
     * @return
     */
    public void delete(Student student){
        studentRepository.delete(student);
    }

    public void delete(Long id){
        Student student=new Student();
        student.setId(id);
        studentRepository.delete(student);
    }
    /**
     * 根据姓名查找
     */

    public List<Student> findByName(String name){
        List<Student> students=studentRepository.findByName(name);
       return students;
    }

    /**
     * 只分页的查询
     * @param pageable
     * @return
     */
    public Page<Student> findAll(Pageable pageable){
        return studentRepository.findAll(pageable);
    };

    /**
     * 分页带过滤的查询
     */
    public Page<Student> findAll(Example<Student> student, Pageable pageable){
        return studentRepository.findAll(student,pageable);
    };

    public Page<Student> findByNameLike(String name,Pageable pageable){
        return studentRepository.findByNameLike(name,pageable);
    };

    public List<Student> findByNoAndPassword(String no,String password){
        return studentRepository.findByNoAndPassword(no,password);
    };

    public Student findByNo(String no){
        return studentRepository.findByNo(no);
    };
}
