package com.nhnacademy.springbootminidooray3gateway.dto.request;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class AddTaskRequest {
    @NonNull @NotNull
    private String title;

    private String content;
}
