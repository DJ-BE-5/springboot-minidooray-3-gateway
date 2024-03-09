package com.nhnacademy.springbootminidooray3gateway.adaptor;

import com.nhnacademy.springbootminidooray3gateway.domain.Project;
import com.nhnacademy.springbootminidooray3gateway.dto.request.AddMemberRequest;
import com.nhnacademy.springbootminidooray3gateway.dto.request.CreateProjectRequest;
import com.nhnacademy.springbootminidooray3gateway.dto.request.ModifyProjectStateRequest;
import com.nhnacademy.springbootminidooray3gateway.dto.response.AddMemberResponse;

import java.util.List;

public interface ProjectAdaptor {
    Project createProject(CreateProjectRequest request, String xUserId);

    List<Project> getProjectList(String xUserId);

    Project getProject(Long projectId, String xUserId);

    AddMemberResponse addMemberToProject(String xUserId, Long projectId, AddMemberRequest request);

    Project modifyProjectState(String xUserId, Long projectId, ModifyProjectStateRequest request);
}
