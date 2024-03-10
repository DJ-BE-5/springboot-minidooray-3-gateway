package com.nhnacademy.springbootminidooray3gateway.controller;

import com.nhnacademy.springbootminidooray3gateway.domain.Member;
import com.nhnacademy.springbootminidooray3gateway.domain.Task;
import com.nhnacademy.springbootminidooray3gateway.dto.request.AddTaskRequest;
import com.nhnacademy.springbootminidooray3gateway.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("projects/{projectId}/tasks/add")
    public String viewAddTaskForm(@SessionAttribute("X-USER") Member xUser,
                                  @PathVariable Long projectId,
                                  Model model) {
        model.addAttribute("projectId", projectId);
        return "add_task";
    }

    @PostMapping("projects/{projectId}/tasks")
    public String addTaskToProject(@SessionAttribute("X-USER") Member xUser,
                                   @PathVariable Long projectId,
                                   @ModelAttribute AddTaskRequest request,
                                   Model model) {
        Task task = taskService.addTaskToProject(xUser, projectId, request);
        model.addAttribute("task", task);
        return "task";
    }

    @GetMapping("/tasks/{taskId}/delete")
    public String removeTask(@SessionAttribute("X-USER") Member xUser,
                             @PathVariable Long taskId) {
        taskService.removeTask(xUser, taskId);
        return "redirect:/";
    }
}
