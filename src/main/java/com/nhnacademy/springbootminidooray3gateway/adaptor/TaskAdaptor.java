package com.nhnacademy.springbootminidooray3gateway.adaptor;

import com.nhnacademy.springbootminidooray3gateway.domain.Task;
import com.nhnacademy.springbootminidooray3gateway.dto.request.AddTaskRequest;
import com.nhnacademy.springbootminidooray3gateway.dto.request.ModifyTaskRequest;

import java.util.List;

public interface TaskAdaptor {
    List<Task> getTasks(String xUserId, Long projectId);

    Task getTask(String xUserId, Long taskId);

    Task addTask(String xUserId, Long projectId, AddTaskRequest request);

    Task modifyTask(String xUserId, Long taskId, ModifyTaskRequest request);
}
