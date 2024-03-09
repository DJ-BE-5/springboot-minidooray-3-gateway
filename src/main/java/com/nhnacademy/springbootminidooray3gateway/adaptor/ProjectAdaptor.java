package com.nhnacademy.springbootminidooray3gateway.adaptor;

import com.nhnacademy.springbootminidooray3gateway.domain.Project;
import com.nhnacademy.springbootminidooray3gateway.dto.request.AddMemberRequest;
import com.nhnacademy.springbootminidooray3gateway.dto.request.CreateProjectRequest;

import java.util.List;

public interface ProjectAdaptor {
    Project createProject(CreateProjectRequest request, String xUserId);

    List<Project> getProjectList(String xUserId);

    Project getProject(String projectId, String xUserId);

    void addMemberToProject(String xUserId, String projectId, AddMemberRequest request);
}
