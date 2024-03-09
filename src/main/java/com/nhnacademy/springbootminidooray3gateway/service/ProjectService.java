package com.nhnacademy.springbootminidooray3gateway.service;

import com.nhnacademy.springbootminidooray3gateway.domain.Member;
import com.nhnacademy.springbootminidooray3gateway.domain.Project;
import com.nhnacademy.springbootminidooray3gateway.dto.request.CreateProjectRequest;

import java.util.List;

public interface ProjectService {
    void createProject(CreateProjectRequest request, Member xUser);

    List<Project> getProjectList(Member xUser);

    Project getProject(String projectId, Member xUser);
}
