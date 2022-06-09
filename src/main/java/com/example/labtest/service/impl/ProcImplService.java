package com.example.labtest.service.impl;

import com.example.labtest.dao.ProcRepository;
import com.example.labtest.domain.Proc;
import com.example.labtest.service.ProcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcImplService implements ProcService {

    @Autowired
    ProcRepository procRepository;

    public List<Proc>findAll(){
        return procRepository.findAll();
    };
    public Proc findByProcno(String procno){
        return procRepository.findByProcno(procno);
    };
    public Proc findByProcname(String procname){
        return procRepository.findByProcname(procname);
    };

    public Page<Proc> findByProcnameLike(String procname, Pageable pageable){
        return procRepository.findByProcnameLike(procname,pageable);
    };
    public Page<Proc> findAll(Pageable pageable){
        return procRepository.findAll(pageable);
    };
    public Page<Proc> findAll(Example<Proc> proc, Pageable pageable){
        return procRepository.findAll(proc,pageable);
    };
    public Proc insert(Proc proc){
        return procRepository.save(proc);
    };
}
