package com.example.labtest.service;

import com.example.labtest.dao.StudentRepository;
import com.example.labtest.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {


     List<Student> findAll();

    /**
     * 插入学生
     * @param student
     * @return
     */
    Student insert(Student student);
    /**
     * 更新学生
     * @param student
     * @return
     */
    Student update(Student student);

    /**
     * 查找学生
     * @param id
     * @return
     */
    Student getById(Long id);
    List<Student> getByName(String name);
    /**
     * 删除学生
     * @param student
     * @return
     */
    void delete(Student student);
    void delete(Long id);
    /**
     * 根据姓名查找
     */

    List<Student> findByName(String name);

    /**
     * 只分页的查询
     * @param pageable
     * @return
     */
    Page<Student> findAll(Pageable pageable);

    /**
     * 分页带过滤的查询
     */
    public Page<Student> findAll(Example<Student> student,Pageable pageable);


    public Page<Student> findByNameLike(String name,Pageable pageable);
    /**
     * 分页带
     */
    public List<Student> findByNoAndPassword(String no,String password);

    public Student findByNo(String no);
}
