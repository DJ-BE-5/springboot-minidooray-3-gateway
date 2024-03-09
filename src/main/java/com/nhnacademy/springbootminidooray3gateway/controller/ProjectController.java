package com.nhnacademy.springbootminidooray3gateway.controller;

import com.nhnacademy.springbootminidooray3gateway.domain.Member;
import com.nhnacademy.springbootminidooray3gateway.dto.request.AddMemberRequest;
import com.nhnacademy.springbootminidooray3gateway.dto.request.CreateProjectRequest;
import com.nhnacademy.springbootminidooray3gateway.dto.request.ModifyProjectStateRequest;
import com.nhnacademy.springbootminidooray3gateway.service.AccountService;
import com.nhnacademy.springbootminidooray3gateway.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;
    private final AccountService accountService;

    @GetMapping("/projects/create")
    public String viewCreateProjectForm() {
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
                              @PathVariable Long projectId,
                              Model model) {
        model.addAttribute("project", projectService.getProject(projectId, xUser));
        return "project";
    }

    @GetMapping("/projects/{projectId}/members/add")
    public String viewAddMemberForm(@PathVariable Long projectId,
                                    @SessionAttribute("X-USER") Member xUser,
                                    Model model) {

        model.addAttribute("accounts", accountService.getAccountList(xUser));
        return "add_member";
    }

    @PostMapping("/projects/{projectId}/members/add")
    public String addMember(@PathVariable Long projectId,
                            @ModelAttribute AddMemberRequest request,
                            @SessionAttribute("X-USER") Member xUser) {
        projectService.addMemberToProject(xUser, projectId, request);
        return "redirect:/projects/" + projectId + "/members/add";
    }

    @PostMapping("/projects/{projectId}/state")
    public String modifyProjectState(@PathVariable Long projectId,
                                     @SessionAttribute("X-USER") Member xUser,
                                     @ModelAttribute ModifyProjectStateRequest request) {
        projectService.modifyProjectState(xUser, projectId, request);
        return "redirect:/projects/" + projectId;
    }
}
