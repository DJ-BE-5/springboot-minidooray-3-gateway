package com.nhnacademy.springbootminidooray3gateway.adaptor;

import com.nhnacademy.springbootminidooray3gateway.domain.Member;
import com.nhnacademy.springbootminidooray3gateway.dto.request.LoginRequest;

import java.util.List;

public interface AccountAdaptor {
    Member login(LoginRequest loginRequest);
    List<Member> getAccountList(String sUserId);
}
