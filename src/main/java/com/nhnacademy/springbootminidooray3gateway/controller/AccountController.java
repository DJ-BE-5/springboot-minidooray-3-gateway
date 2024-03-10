package com.nhnacademy.springbootminidooray3gateway.controller;

import com.nhnacademy.springbootminidooray3gateway.domain.Member;
import com.nhnacademy.springbootminidooray3gateway.dto.request.LoginRequest;
import com.nhnacademy.springbootminidooray3gateway.dto.request.SignUpRequestDto;
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
    public ModelAndView doLogin(@SessionAttribute(name = "X-USER", required = false) Member member,
                                @ModelAttribute LoginRequest loginRequest,
                                HttpServletRequest request) {
        if(!Objects.isNull(member)) {
            return new ModelAndView("redirect:/");
        }
        Member loginMember = accountService.login(loginRequest);

        HttpSession session = request.getSession(true);
        session.setAttribute("X-USER", loginMember);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/logout")
    public String doLogout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(Objects.isNull(session) || Objects.isNull(session.getAttribute("X-USER"))) {
            return "redirect:/login";
        }
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/signup")
    public String viewSignUpForm(@SessionAttribute(name = "X-USER", required = false) Member member) {
        if(!Objects.isNull(member)) {
            return "redirect:/";
        }
        return "signup";
    }

    @PostMapping("/signup")
    public String doSignUp(@SessionAttribute(name = "X-USER", required = false) Member member,
                           @ModelAttribute SignUpRequestDto request) {
        if(!Objects.isNull(member)) {
            return "redirect:/";
        }

        accountService.signUp(request);
        return "redirect:/login";
    }
}
