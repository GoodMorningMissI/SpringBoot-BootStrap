package com.example.labtest.webapi;

import com.example.labtest.domain.Admin;
import com.example.labtest.domain.Student;
import com.example.labtest.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@RestController
@RequestMapping("/webapi/admin")
public class AdminRestController {
    @Autowired
    private AdminService adminService;

    /**
     * 修改密码方法
     */
    @GetMapping("/changepassword")
    public int changepassword(String old_password, String new_password, HttpServletRequest request){
        HttpSession session=request.getSession();
        String no= (String) session.getAttribute("adminno");
        System.out.println(no);
        Admin admin=adminService.findByNoAndPassword(no,old_password);
        if(admin!=null){
            if(Objects.equals(admin.getPassword(), old_password)){
                admin.setPassword(new_password);
                adminService.update(admin);
                return 1;
            }
            else {
                return -1;
            }
        }else{
            return -1;
        }

    }
}
