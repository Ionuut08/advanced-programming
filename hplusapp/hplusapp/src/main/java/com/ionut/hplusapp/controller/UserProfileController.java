package com.ionut.hplusapp.controller;

import com.ionut.hplusapp.model.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserProfileController {

    @PostMapping("/userprofile")
    public String getUserProfile(@SessionAttribute("login") Login login, Model model) {
        System.out.println("In user profile controller");
        System.out.println("username from session: " + login.getUsername());
        model.addAttribute("username", login.getUsername());
        return "profile";
    }
}
