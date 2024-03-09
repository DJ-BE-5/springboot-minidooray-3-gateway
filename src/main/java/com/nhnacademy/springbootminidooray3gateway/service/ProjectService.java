package com.nhnacademy.springbootminidooray3gateway.service;

import com.nhnacademy.springbootminidooray3gateway.domain.Member;
import com.nhnacademy.springbootminidooray3gateway.dto.request.CreateProjectRequest;

public interface ProjectService {
    void createProject(CreateProjectRequest request, Member xUser);
}
