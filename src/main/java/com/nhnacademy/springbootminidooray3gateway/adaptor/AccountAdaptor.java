package com.nhnacademy.springbootminidooray3gateway.adaptor;

import com.nhnacademy.springbootminidooray3gateway.domain.Member;
import com.nhnacademy.springbootminidooray3gateway.dto.request.LoginRequest;

public interface AccountAdaptor {
    Member login(LoginRequest loginRequest);
}
