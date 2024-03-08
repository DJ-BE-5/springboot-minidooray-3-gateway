package com.nhnacademy.springbootminidooray3gateway.controller;

import com.nhnacademy.springbootminidooray3gateway.dto.request.LoginRequest;
import com.nhnacademy.springbootminidooray3gateway.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping("/login")
    public ModelAndView viewLogin(@SessionAttribute(name = "X-USER-ID", required = false) String xUserId) {
        if(StringUtils.hasLength(xUserId)) {
            ModelAndView mav = new ModelAndView("redirect:/");
            return mav;
        }

        ModelAndView mav = new ModelAndView("login");
        return mav;
    }

    @PostMapping("/login")
    public ModelAndView doLogin(@ModelAttribute LoginRequest loginRequest) {
        accountService.login(loginRequest);
        ModelAndView mav = new ModelAndView("redirect:/");
        return mav;
    }
}
