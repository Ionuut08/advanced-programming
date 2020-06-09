package com.ionut.hplusapp.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;

@Controller
public class LogoutController {

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        System.out.println("Ending user session");
        session.invalidate();
        // System.out.println(session.getAttribute("login")); //should not appear
        return "login";
    }
}
