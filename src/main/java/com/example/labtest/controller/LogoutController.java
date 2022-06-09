package com.example.labtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {

    @RequestMapping("/logout")
    public String logout(HttpSession session, SessionStatus sessionStatus){
        System.out.println("logout");
        session.removeAttribute("userid");
        sessionStatus.setComplete();
        return "redirect:/login/user";
    }
}
