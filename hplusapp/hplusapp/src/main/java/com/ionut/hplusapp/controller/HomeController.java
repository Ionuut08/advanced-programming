package com.ionut.hplusapp.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String goHome() {
        System.out.println("We are in home controller");
        return "index";
    }

    @GetMapping("/goToSearch")
    public String goToSearch() {
        System.out.println("going to search page");
        return "search";
    }

    @GetMapping("/goToLogin")
    public String goToLogin() {
        System.out.println("going to login page");
        return "login";
    }

    @GetMapping("/goToRegistration")
    public String goToRegistration() {
        System.out.println("going to registration page");
        return "register";
    }

//    @ModelAttribute("newuser")
//    public User getDefaultUser() {
//        return new User();
//    }
//
//    @ModelAttribute("genderItems")
//    public List<String> getGenderItems() {
//        return Arrays.asList("Male", "Female");
//    }
//
//    @ModelAttribute("login")
//    public Login getDefaultLogin() {
//        return new Login();
//    }

}
