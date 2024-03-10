package com.nhnacademy.springbootminidooray3gateway.adaptor.impl;

import com.nhnacademy.springbootminidooray3gateway.adaptor.ProjectAdaptor;
import com.nhnacademy.springbootminidooray3gateway.domain.Project;
import com.nhnacademy.springbootminidooray3gateway.dto.request.AddMemberRequest;
import com.nhnacademy.springbootminidooray3gateway.dto.request.CreateProjectRequest;
import com.nhnacademy.springbootminidooray3gateway.dto.request.ModifyProjectStateRequest;
import com.nhnacademy.springbootminidooray3gateway.dto.response.AddMemberResponse;
import com.nhnacademy.springbootminidooray3gateway.exception.CommonProjectException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
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
    private final ParameterizedTypeReference<List<Project>> projectListType = new ParameterizedTypeReference<>() {};

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

    @Override
    public List<Project> getProjectList(String xUserId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        httpHeaders.set("X-USER-ID", xUserId);


        try {

            RequestEntity<Void> requestEntity =
                    RequestEntity
                            .get(taskServiceUrl + "/projects")
                            .headers(httpHeaders)
                            .build();

            ResponseEntity<List<Project>> exchange = restTemplate.exchange(requestEntity, projectListType);

            if(!exchange.getStatusCode().is2xxSuccessful()) {
                throw new CommonProjectException();
            }

            return exchange.getBody();
        } catch(Exception e) {
            throw new CommonProjectException();
        }
    }

    @Override
    public Project getProject(Long projectId, String xUserId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        httpHeaders.set("X-USER-ID", xUserId);

        try {
            RequestEntity<Void> requestEntity = RequestEntity.get(taskServiceUrl + "/projects/" + projectId)
                    .headers(httpHeaders)
                    .build();
            ResponseEntity<Project> exchange = restTemplate.exchange(requestEntity, Project.class);

            if(!exchange.getStatusCode().is2xxSuccessful()) {
                throw new CommonProjectException();
            }

            return exchange.getBody();
        } catch(RestClientException ex) {
            throw new CommonProjectException();
        }
    }

    @Override
    public AddMemberResponse addMemberToProject(String xUserId, Long projectId, AddMemberRequest request) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        httpHeaders.set("X-USER-ID", xUserId);

        try {
            RequestEntity<AddMemberRequest> requestEntity = RequestEntity
                    .post(taskServiceUrl + "/projects/" + projectId + "/members")
                    .headers(httpHeaders)
                    .body(request);
            ResponseEntity<AddMemberResponse> exchange = restTemplate.exchange(requestEntity, AddMemberResponse.class);

            if(!exchange.getStatusCode().is2xxSuccessful()) {
                throw new CommonProjectException();
            }

            return exchange.getBody();
        } catch(RestClientException ex) {
            throw new CommonProjectException();
        }
    }

    @Override
    public Project modifyProjectState(String xUserId, Long projectId, ModifyProjectStateRequest request) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        httpHeaders.set("X-USER-ID", xUserId);

        try {
            RequestEntity<ModifyProjectStateRequest> requestEntity = RequestEntity
                    .put(taskServiceUrl + "/project/" + projectId)
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
