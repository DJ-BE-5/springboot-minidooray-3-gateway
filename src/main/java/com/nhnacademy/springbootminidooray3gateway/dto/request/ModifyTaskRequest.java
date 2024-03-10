package com.nhnacademy.springbootminidooray3gateway.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ModifyTaskRequest {
    private String title;
    private String content;
    private String memberId;
    private String projectId;
}
