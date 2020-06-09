package com.ionut.hplusapp.exceptions;

import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public String handleException() {
        System.out.println("in global exception handler");
        return "error";
    }
}
