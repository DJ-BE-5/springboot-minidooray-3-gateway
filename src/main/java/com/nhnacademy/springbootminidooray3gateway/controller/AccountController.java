package com.nhnacademy.springbootminidooray3gateway.controller;

import com.nhnacademy.springbootminidooray3gateway.domain.Member;
import com.nhnacademy.springbootminidooray3gateway.dto.request.LoginRequest;
import com.nhnacademy.springbootminidooray3gateway.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping("/login")
    public ModelAndView viewLogin(@SessionAttribute(name = "X-USER", required = false) Member member) {
        if(!Objects.isNull(member)) {
            return new ModelAndView("redirect:/");
        }
        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public ModelAndView doLogin(@ModelAttribute LoginRequest loginRequest,
                                HttpServletRequest request) {
        Member member = accountService.login(loginRequest);

        HttpSession session = request.getSession(true);
        session.setAttribute("X-USER", member);
        return new ModelAndView("redirect:/");
    }
}
