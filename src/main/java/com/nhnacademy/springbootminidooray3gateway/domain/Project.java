package com.nhnacademy.springbootminidooray3gateway.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Project  implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long projectId;
    private String title;
    private String content;
    private ProjectState state;
    private String adminId;
}
