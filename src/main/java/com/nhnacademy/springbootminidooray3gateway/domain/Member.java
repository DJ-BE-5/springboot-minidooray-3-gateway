package com.nhnacademy.springbootminidooray3gateway.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Member implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String email;
    private MemberState state;
}
