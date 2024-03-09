package com.nhnacademy.springbootminidooray3gateway.controller;

import com.nhnacademy.springbootminidooray3gateway.domain.Member;
import com.nhnacademy.springbootminidooray3gateway.dto.request.CreateProjectRequest;
import com.nhnacademy.springbootminidooray3gateway.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping("/projects/create")
    public String viewCreateProject() {
        return "create_project";
    }

    @PostMapping("/projects/create")
    public String createProject(@SessionAttribute("X-USER") Member xUser,
                                @ModelAttribute CreateProjectRequest request) {
        projectService.createProject(request, xUser);
        return "redirect:/";
    }

    @GetMapping("/projects/{projectId}")
    public String viewProject(@SessionAttribute("X-USER") Member xUser,
                              @PathVariable String projectId,
                              Model model) {
        model.addAttribute("project", projectService.getProject(projectId, xUser));
        return "project";
    }
}
