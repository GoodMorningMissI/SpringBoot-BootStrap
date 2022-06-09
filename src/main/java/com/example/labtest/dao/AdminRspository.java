package com.example.labtest.dao;
import com.example.labtest.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRspository extends JpaRepository<Admin,Long> {
    public Admin findByNoAndPassword(String no,String password);
}
