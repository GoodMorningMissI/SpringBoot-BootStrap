package com.example.labtest.controller;

import com.example.labtest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class InformationController {
    @Autowired
    StudentService studentService;

    @RequestMapping("/student/information")
    public String list(HttpServletRequest httpRequest, Model model){
        HttpSession session=httpRequest.getSession();
        if(session.getAttribute("userid")==null){
            return "redirect:/login/user";
        }
        return "student/information";
    }

    @RequestMapping("/student/stuinfor")
    public String findstuinfor(HttpServletRequest httpRequest, Model model){
        HttpSession session=httpRequest.getSession();
        if(session.getAttribute("userid")==null){
            return "redirect:/login/user";
        }
        return "student/stuinfor";
    }

    @RequestMapping("/student/studentscore")
    public String getstudentscore(HttpServletRequest httpRequest, Model model){
        HttpSession session=httpRequest.getSession();
        if(session.getAttribute("userid")==null){
            return "redirect:/login/user";
        }
        return "student/studentscore";
    }

    @RequestMapping("/student/cultivateplan")
    public String cultivateplan(HttpServletRequest httpRequest, Model model){
        HttpSession session=httpRequest.getSession();
        if(session.getAttribute("userid")==null){
            return "redirect:/login/user";
        }
        return "student/cultivateplan";
    }

    @RequestMapping("/admin/adminmain")
    public String admin(HttpServletRequest httpRequest, Model model){
        HttpSession session=httpRequest.getSession();
        if(session.getAttribute("userid")==null){
            return "redirect:/login/user";
        }
        return "admin/adminmain";
    }

    @RequestMapping("/admin/StudentScoreManage")
    public String findscore(HttpServletRequest httpRequest, Model model){
        HttpSession session=httpRequest.getSession();
        if(session.getAttribute("userid")==null){
            return "redirect:/login/user";
        }
        return "admin/StudentScoreManage";
    }
    @RequestMapping("/admin/coursemanage")
    public String managecourse(HttpServletRequest httpRequest, Model model){
        HttpSession session=httpRequest.getSession();
        if(session.getAttribute("userid")==null){
            return "redirect:/login/user";
        }
        return "admin/coursemanage";
    }



}
