package com.example.labtest.service;

import com.example.labtest.domain.Admin;
import com.example.labtest.domain.Student;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {

    public Admin findByNoAndPassword(String no,String password);
    public Admin update(Admin admin);
}
