package com.nhnacademy.springbootminidooray3gateway.dto.request;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    @NotNull @NonNull
    private String id;

    @NotNull @NonNull
    private String password;
}
