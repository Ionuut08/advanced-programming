package com.ionut.hplusapp.controller;

import com.ionut.hplusapp.model.*;
import com.ionut.hplusapp.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.beans.propertyeditors.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.validation.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/registerusers")
    public String registerUser(@ModelAttribute("newuser") @Validated User user, BindingResult result, Model model) {
        System.out.println("in registration controller");

        if (result.hasErrors()) {
            return "register";
        }

        userRepository.save(user);
        model.addAttribute("dataSaved", "User registered successfully!");
        return "login";
    }


}
