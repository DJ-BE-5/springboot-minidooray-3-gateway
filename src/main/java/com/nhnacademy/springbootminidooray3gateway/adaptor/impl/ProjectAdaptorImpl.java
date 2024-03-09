package com.nhnacademy.springbootminidooray3gateway.adaptor.impl;

import com.nhnacademy.springbootminidooray3gateway.adaptor.ProjectAdaptor;
import com.nhnacademy.springbootminidooray3gateway.domain.Project;
import com.nhnacademy.springbootminidooray3gateway.dto.request.CreateProjectRequest;
import com.nhnacademy.springbootminidooray3gateway.exception.CommonProjectException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProjectAdaptorImpl implements ProjectAdaptor {
    private final RestTemplate restTemplate;

    @Value("${task.service.url}")
    private String taskServiceUrl;

    @Override
    public Project createProject(CreateProjectRequest request, String xUserId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        httpHeaders.set("X-USER-ID", xUserId);

        try {
            RequestEntity<CreateProjectRequest> requestEntity = RequestEntity.post(taskServiceUrl + "/projects")
                    .headers(httpHeaders)
                    .body(request);
            ResponseEntity<Project> exchange = restTemplate.exchange(requestEntity, Project.class);

            if(!exchange.getStatusCode().is2xxSuccessful()) {
                throw new CommonProjectException();
            }

            return exchange.getBody();
        } catch(RestClientException ex) {
            throw new CommonProjectException();
        }
    }
}
