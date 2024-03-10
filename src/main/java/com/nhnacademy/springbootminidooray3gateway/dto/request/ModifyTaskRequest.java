package com.nhnacademy.springbootminidooray3gateway.dto.request;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ModifyTaskRequest {
    @NotNull @NonNull
    private String title;

    private String content;
}
