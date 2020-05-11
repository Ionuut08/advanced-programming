package com.example.ionut.restapplication.web;

import com.example.ionut.restapplication.domain.User;
import com.example.ionut.restapplication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signin")
    @PreAuthorize("hasRole('ROLE_GC')")
    public String login(@RequestBody @Valid LoginDto loginDto) {
        return userService.signin(loginDto.getUsername(), loginDto.getPassword()).orElseThrow(() ->
                new HttpServerErrorException(HttpStatus.FORBIDDEN, "Login failed"));
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public User signup(@RequestBody @Valid LoginDto loginDto) {
        return userService.signup(loginDto.getUsername(), loginDto.getPassword(),
                loginDto.getFirstName(), loginDto.getLastName())
                .orElseThrow(() -> new RuntimeException("User already exists"));
    }

    @GetMapping
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<User> getAllUsers() {return userService.getAll();}
}
