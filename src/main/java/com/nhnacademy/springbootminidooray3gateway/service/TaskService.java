package com.nhnacademy.springbootminidooray3gateway.service;

import com.nhnacademy.springbootminidooray3gateway.domain.Member;
import com.nhnacademy.springbootminidooray3gateway.domain.Task;
import com.nhnacademy.springbootminidooray3gateway.dto.request.AddTaskRequest;
import com.nhnacademy.springbootminidooray3gateway.dto.request.ModifyTaskRequest;

import java.util.List;

public interface TaskService {
    List<Task> getTasksByProjectId(Member xUser, Long projectId);

    Task getTask(Member xUser, Long taskId);

    void addTaskToProject(Member xUser, Long projectId, AddTaskRequest request);

    void modifyTask(Member xUser, Long taskId, ModifyTaskRequest request);
}
