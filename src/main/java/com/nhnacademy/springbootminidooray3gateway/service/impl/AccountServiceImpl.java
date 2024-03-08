package com.nhnacademy.springbootminidooray3gateway.service.impl;

import com.nhnacademy.springbootminidooray3gateway.adaptor.AccountAdaptor;
import com.nhnacademy.springbootminidooray3gateway.domain.Member;
import com.nhnacademy.springbootminidooray3gateway.dto.request.LoginRequest;
import com.nhnacademy.springbootminidooray3gateway.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountAdaptor accountAdaptor;

    @Override
    public Member login(LoginRequest loginRequest) {
        return accountAdaptor.login(loginRequest);
    }
}
