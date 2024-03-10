package com.nhnacademy.springbootminidooray3gateway.controller;

import com.nhnacademy.springbootminidooray3gateway.domain.Member;
import com.nhnacademy.springbootminidooray3gateway.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping("tasks/{taskId}")
    public String viewTask(@SessionAttribute("X-USER") Member xUser,
                           @PathVariable Long taskId,
                           Model model) {
        model.addAttribute("task", taskService.getTask(xUser, taskId));
        return "task";
    }
}
