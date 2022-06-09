package com.example.labtest.dao;

import com.example.labtest.domain.Proc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProcRepository extends JpaRepository<Proc,Long>  {
    public Proc findByProcname(String procname);
    public Proc findByProcno(String procno);
    Page<Proc> findByProcnameLike(String procname, Pageable pageable);
}
