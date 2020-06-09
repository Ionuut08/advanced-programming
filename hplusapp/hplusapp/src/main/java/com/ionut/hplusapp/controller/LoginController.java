package com.ionut.hplusapp.controller;

import com.ionut.hplusapp.exceptions.*;
import com.ionut.hplusapp.model.*;
import com.ionut.hplusapp.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;

@Controller
@SessionAttributes("login")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public String login(@ModelAttribute("login") Login login, HttpSession session) {
        User user = userRepository.searchByName(login.getUsername());
        if (user == null) {
            throw new ApplicationException("User not found");
        }
        return "forward:/userprofile";
    }

    @ExceptionHandler(ApplicationException.class)
    public String handleException() {
        System.out.println("in exception handler of Login");
        return "error";
    }
}
