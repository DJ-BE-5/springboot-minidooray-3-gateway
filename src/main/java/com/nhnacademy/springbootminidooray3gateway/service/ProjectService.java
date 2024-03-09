package com.nhnacademy.springbootminidooray3gateway.service;

import com.nhnacademy.springbootminidooray3gateway.domain.Member;
import com.nhnacademy.springbootminidooray3gateway.domain.Project;
import com.nhnacademy.springbootminidooray3gateway.dto.request.AddMemberRequest;
import com.nhnacademy.springbootminidooray3gateway.dto.request.CreateProjectRequest;
import com.nhnacademy.springbootminidooray3gateway.dto.request.ModifyProjectStateRequest;

import java.util.List;

public interface ProjectService {
    void createProject(CreateProjectRequest request, Member xUser);

    List<Project> getProjectList(Member xUser);

    Project getProject(Long projectId, Member xUser);

    void addMemberToProject(Member xUser, Long projectId, AddMemberRequest request);

    void modifyProjectState(Member xUser, Long projectId, ModifyProjectStateRequest request);
}
