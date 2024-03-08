package com.nhnacademy.springbootminidooray3gateway.domain;

import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private String id;
    private String email;
    private String state;
}
