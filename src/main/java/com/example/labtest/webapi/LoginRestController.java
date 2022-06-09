package com.example.labtest.webapi;

import com.example.labtest.domain.Admin;
import com.example.labtest.domain.Student;
import com.example.labtest.helper.R;
import com.example.labtest.helper.RUtil;
import com.example.labtest.service.AdminService;
import com.example.labtest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/webapi/login")
public class LoginRestController {
    @Autowired
    StudentService studentService;

    @Autowired
    AdminService adminService;

    @GetMapping("/user")
    public int user(HttpServletRequest httprequest,String no,String password,String choice){
        if(choice.equals("1")){
            List<Student> students=studentService.findByNoAndPassword(no,password);
            if(students.size()>0){
                HttpSession session=httprequest.getSession();
                session.setAttribute("userid",students.get(0).getId());
                session.setAttribute("stuno",students.get(0).getNo());
                session.setAttribute("stuname",students.get(0).getName());
                session.setAttribute("stupassword",students.get(0).getPassword());
//                session.setAttribute("user",students.get(0));
                return 1;//成功
            }else {
                return -1;//不存在用户
            }
        }
        else {
            Admin admin= adminService.findByNoAndPassword(no, password);
            if(admin !=null){
                HttpSession session=httprequest.getSession();
                session.setAttribute("userid",admin.getId());
                session.setAttribute("adminno",admin.getNo());
                session.setAttribute("admname",admin.getName());
                session.setAttribute("admpassword",admin.getPassword());
                return 2;
            }else {
                return -1;
            }
        }


    }

}
