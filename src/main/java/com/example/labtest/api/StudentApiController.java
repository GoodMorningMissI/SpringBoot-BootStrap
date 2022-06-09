package com.example.labtest.api;


import com.example.labtest.domain.Student;
import com.example.labtest.helper.R;
import com.example.labtest.helper.RUtil;
import com.example.labtest.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/student")
public class StudentApiController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/findbyname")
    public R<Student> findByname(String name, String order, Integer limit, Integer offset){
        Page<Student> all;
        Pageable pageable= PageRequest.of(offset/limit,limit,
                Sort.by("id").descending());
        if (name==null||name.equals("")){
            all=studentService.findAll(pageable);
        }else {
            all=studentService.findByNameLike("%"+name+"%",pageable);
        }
        return RUtil.success(all);
    }

    @PostMapping("/add")
    public R add(@Validated Student student, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        return null;
    }
}
