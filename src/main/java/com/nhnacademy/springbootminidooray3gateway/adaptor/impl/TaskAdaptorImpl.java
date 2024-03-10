package com.nhnacademy.springbootminidooray3gateway.adaptor.impl;

import com.nhnacademy.springbootminidooray3gateway.adaptor.TaskAdaptor;
import com.nhnacademy.springbootminidooray3gateway.domain.Task;
import com.nhnacademy.springbootminidooray3gateway.dto.request.AddTaskRequest;
import com.nhnacademy.springbootminidooray3gateway.dto.request.ModifyTaskRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TaskAdaptorImpl implements TaskAdaptor {
    private final RestTemplate restTemplate;

    ParameterizedTypeReference<List<Task>> taskListType = new ParameterizedTypeReference<>() {};

    @Value("${task.service.url}")
    private String taskServiceUrl;

    @Override
    public List<Task> getTasks(String xUserId, Long projectId) {
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
            httpHeaders.set("X-USER-ID", xUserId);

            RequestEntity<Void> requestEntity = RequestEntity.get(taskServiceUrl + "/projects/" + projectId + "/tasks")
                    .headers(httpHeaders)
                    .build();
            ResponseEntity<List<Task>> exchange = restTemplate.exchange(requestEntity, taskListType);

            if(!exchange.getStatusCode().is2xxSuccessful()) {
                throw new RuntimeException();
            }

            return exchange.getBody();
        } catch(Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Task getTask(String xUserId, Long taskId) {
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
            httpHeaders.set("X-USER-ID", xUserId);

            RequestEntity<Void> requestEntity = RequestEntity.get(taskServiceUrl + "/tasks/" + taskId)
                    .headers(httpHeaders)
                    .build();
            ResponseEntity<Task> exchange = restTemplate.exchange(requestEntity, Task.class);

            if(!exchange.getStatusCode().is2xxSuccessful()) {
                throw new RuntimeException();
            }

            return exchange.getBody();
        } catch(Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Task addTask(String xUserId, Long projectId, AddTaskRequest request) {
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
            httpHeaders.set("X-USER-ID", xUserId);

            RequestEntity<AddTaskRequest> requestEntity = RequestEntity
                    .post(taskServiceUrl + "/projects/" + projectId + "/tasks")
                    .headers(httpHeaders)
                    .body(request);
            ResponseEntity<Task> exchange = restTemplate.exchange(requestEntity, Task.class);

            if(!exchange.getStatusCode().is2xxSuccessful())
                throw new RuntimeException();

            return exchange.getBody();
        } catch(Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Task modifyTask(String xUserId, Long taskId, ModifyTaskRequest request) {
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
            httpHeaders.set("X-USER-ID", xUserId);

            RequestEntity<ModifyTaskRequest> requestEntity = RequestEntity
                    .put(taskServiceUrl + "/tasks/" + taskId)
                    .body(request);
            ResponseEntity<Task> exchange = restTemplate.exchange(requestEntity, Task.class);

            if(!exchange.getStatusCode().is2xxSuccessful())
                throw new RuntimeException();

            return exchange.getBody();
        } catch(Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
