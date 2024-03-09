package com.nhnacademy.springbootminidooray3gateway.controller;

import com.nhnacademy.springbootminidooray3gateway.domain.Member;
import com.nhnacademy.springbootminidooray3gateway.domain.Project;
import com.nhnacademy.springbootminidooray3gateway.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final ProjectService projectService;

    @GetMapping("/")
    public ModelAndView home(@SessionAttribute(value = "X-USER", required = false) Member xUser) {
        ModelAndView mav = new ModelAndView("index");

        if(!Objects.isNull(xUser)) {
            List<Project> projectList = projectService.getProjectList(xUser);
            mav.addObject("projects", projectList);
        }

        return mav;
    }
}
