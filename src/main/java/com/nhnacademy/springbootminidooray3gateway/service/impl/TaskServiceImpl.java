package com.nhnacademy.springbootminidooray3gateway.service.impl;

import com.nhnacademy.springbootminidooray3gateway.adaptor.TaskAdaptor;
import com.nhnacademy.springbootminidooray3gateway.domain.Member;
import com.nhnacademy.springbootminidooray3gateway.domain.Task;
import com.nhnacademy.springbootminidooray3gateway.dto.request.AddTaskRequest;
import com.nhnacademy.springbootminidooray3gateway.dto.request.ModifyTaskRequest;
import com.nhnacademy.springbootminidooray3gateway.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskAdaptor taskAdaptor;

    @Override
    public List<Task> getTasksByProjectId(Member xUser, Long projectId) {
        return taskAdaptor.getTasks(xUser.getId(), projectId);
    }

    @Override
    public Task getTask(Member xUser, Long taskId) {
        return taskAdaptor.getTask(xUser.getId(), taskId);
    }

    @Override
    public void addTaskToProject(Member xUser, Long projectId, AddTaskRequest request) {
        taskAdaptor.addTask(xUser.getId(), projectId, request);
    }

    @Override
    public void modifyTask(Member xUser, Long taskId, ModifyTaskRequest request) {
        taskAdaptor.modifyTask(xUser.getId(), taskId, request);
    }
}
