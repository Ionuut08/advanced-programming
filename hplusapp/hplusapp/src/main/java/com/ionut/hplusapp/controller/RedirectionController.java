package com.ionut.hplusapp.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class RedirectionController {

    @GetMapping("/redirectToLinkedIn")
    public String redirectOut() {
        System.out.println("In redirect controller");
        return "redirect:http://www.linkedin.com";
    }
}
