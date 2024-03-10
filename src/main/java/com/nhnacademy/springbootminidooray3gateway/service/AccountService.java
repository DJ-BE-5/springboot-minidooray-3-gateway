package com.nhnacademy.springbootminidooray3gateway.service;

import com.nhnacademy.springbootminidooray3gateway.domain.Member;
import com.nhnacademy.springbootminidooray3gateway.dto.request.LoginRequest;
import com.nhnacademy.springbootminidooray3gateway.dto.request.SignUpRequestDto;

import java.util.List;

public interface AccountService {
    Member login(LoginRequest loginRequest);

    List<Member> getAccountList(Member xUser);

    void signUp(SignUpRequestDto request);
}
