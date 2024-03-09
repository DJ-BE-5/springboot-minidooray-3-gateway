package com.nhnacademy.springbootminidooray3gateway.domain;

import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    private String projectId;
    private String title;
    private String content;
    private State state;
    private String adminId;
}
