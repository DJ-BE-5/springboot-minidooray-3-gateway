package com.nhnacademy.springbootminidooray3gateway.service.impl;

import com.nhnacademy.springbootminidooray3gateway.adaptor.ProjectAdaptor;
import com.nhnacademy.springbootminidooray3gateway.domain.Member;
import com.nhnacademy.springbootminidooray3gateway.domain.Project;
import com.nhnacademy.springbootminidooray3gateway.dto.request.CreateProjectRequest;
import com.nhnacademy.springbootminidooray3gateway.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectAdaptor projectAdaptor;
    @Override
    public void createProject(CreateProjectRequest request, Member xUser) {
        projectAdaptor.createProject(request, xUser.getId());
    }

    @Override
    public List<Project> getProjectList(Member xUser) {
        return projectAdaptor.getProjectList(xUser.getId());
    }
}
