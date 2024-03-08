package com.nhnacademy.springbootminidooray3gateway.advice;

import com.nhnacademy.springbootminidooray3gateway.exception.LoginFailedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommonontrollerAdvice {
    @ExceptionHandler(LoginFailedException.class)
    public ModelAndView handleLoginFailedException(LoginFailedException ex) {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("error", "Login failed");
        return mav;
    }
}
