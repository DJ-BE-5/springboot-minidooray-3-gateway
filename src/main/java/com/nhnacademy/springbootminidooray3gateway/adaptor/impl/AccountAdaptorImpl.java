package com.nhnacademy.springbootminidooray3gateway.adaptor.impl;

import com.nhnacademy.springbootminidooray3gateway.adaptor.AccountAdaptor;
import com.nhnacademy.springbootminidooray3gateway.domain.Member;
import com.nhnacademy.springbootminidooray3gateway.dto.request.LoginRequest;
import com.nhnacademy.springbootminidooray3gateway.dto.request.SignUpRequestDto;
import com.nhnacademy.springbootminidooray3gateway.exception.CommonAccountException;
import com.nhnacademy.springbootminidooray3gateway.exception.ConflictException;
import com.nhnacademy.springbootminidooray3gateway.exception.LoginFailedException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AccountAdaptorImpl implements AccountAdaptor {
    private final RestTemplate restTemplate;

    private final ParameterizedTypeReference<List<Member>> memberListType = new ParameterizedTypeReference<>() {};

    @Value("${account.service.url}")
    private String accountServiceUrl;

    @Override
    public Member login(LoginRequest loginRequest) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        try {
            RequestEntity<LoginRequest> requestEntity = RequestEntity.post(accountServiceUrl + "/login").headers(httpHeaders).body(loginRequest);
            ResponseEntity<Member> exchange = restTemplate.exchange(requestEntity, Member.class);

            if(!exchange.getStatusCode().is2xxSuccessful()) {
                throw new LoginFailedException();
            }

            return exchange.getBody();
        } catch(HttpClientErrorException.Unauthorized ex) {
            throw new LoginFailedException();
        } catch(RestClientException ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<Member> getAccountList(String xUserId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        httpHeaders.set("X-USER-ID", xUserId);

        try {
            RequestEntity requestEntity = RequestEntity.get(accountServiceUrl + "/accounts").headers(httpHeaders).build();
            ResponseEntity<List<Member>> exchange = restTemplate.exchange(requestEntity, memberListType);

            if(!exchange.getStatusCode().is2xxSuccessful()) {
                throw new CommonAccountException();
            }

            return exchange.getBody();
        } catch(RestClientException ex) {
            throw new CommonAccountException();
        }
    }

    @Override
    public Member signUp(SignUpRequestDto request) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        try {
            RequestEntity<SignUpRequestDto> requestEntity = RequestEntity
                    .post(accountServiceUrl + "/signup")
                    .headers(httpHeaders)
                    .body(request);
            ResponseEntity<Member> exchange = restTemplate
                    .exchange(requestEntity, Member.class);

            if(!exchange.getStatusCode().is2xxSuccessful()) {
                throw new RuntimeException();
            }

            return exchange.getBody();
        } catch(HttpClientErrorException.Conflict ex) {
            throw new ConflictException();
        } catch(RestClientException ex) {
            throw new RuntimeException();
        }
    }
}
