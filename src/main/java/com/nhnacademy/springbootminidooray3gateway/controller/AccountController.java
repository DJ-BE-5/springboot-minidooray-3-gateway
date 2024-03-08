package com.nhnacademy.springbootminidooray3gateway.controller;

import com.nhnacademy.springbootminidooray3gateway.domain.Member;
import com.nhnacademy.springbootminidooray3gateway.dto.request.LoginRequest;
import com.nhnacademy.springbootminidooray3gateway.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping("/login")
    public ModelAndView viewLogin(@SessionAttribute(name = "X-USER-ID", required = false) String xUserId,
                                  HttpServletRequest request) {
        if(StringUtils.hasLength(xUserId)) {
            ModelAndView mav = new ModelAndView("redirect:/");
            return mav;
        }

        ModelAndView mav = new ModelAndView("login");
        return mav;
    }

    @PostMapping("/login")
    public ModelAndView doLogin(@ModelAttribute LoginRequest loginRequest,
                                HttpServletRequest request) {
        Member member = accountService.login(loginRequest);

        HttpSession session = request.getSession(true);
        session.setAttribute(member.getId(), member);
        ModelAndView mav = new ModelAndView("redirect:/");
        return mav;
    }
}
