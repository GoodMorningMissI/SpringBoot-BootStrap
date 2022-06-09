package com.example.labtest.service.impl;

import com.example.labtest.dao.AdminRspository;
import com.example.labtest.domain.Admin;
import com.example.labtest.domain.Student;
import com.example.labtest.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminImplService implements AdminService {
    @Autowired
    AdminRspository adminRspository;


    public Admin findByNoAndPassword(String no, String password){
        return adminRspository.findByNoAndPassword(no,password);
    };
        public Admin update(Admin admin){
        return adminRspository.save(admin);
    }

}
