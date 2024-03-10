package com.nhnacademy.springbootminidooray3gateway.advice;

import com.nhnacademy.springbootminidooray3gateway.exception.ConflictException;
import com.nhnacademy.springbootminidooray3gateway.exception.LoginFailedException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommonControllerAdvice {
    @ExceptionHandler(LoginFailedException.class)
    public ModelAndView LoginFailedHandler(LoginFailedException ex) {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("error");
        return mav;
    }

    @ExceptionHandler(ConflictException.class)
    public String conflictHandler(ConflictException ex, Model model) {
        model.addAttribute("error", ex);
        return "error";
    }
}
