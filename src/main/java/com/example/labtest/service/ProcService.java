package com.example.labtest.service;

import com.example.labtest.domain.Proc;
import com.example.labtest.domain.Score;
import com.example.labtest.domain.Student;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProcService {
    public List<Proc> findAll();
    public Proc findByProcno(String procno);
    public Proc findByProcname(String procname);
    public Page<Proc> findByProcnameLike(String procname, Pageable pageable);
    public Page<Proc> findAll(Pageable pageable);
    public Page<Proc> findAll(Example<Proc> proc, Pageable pageable);
    public Proc insert(Proc proc);

}
