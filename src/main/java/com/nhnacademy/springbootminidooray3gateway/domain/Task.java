package com.nhnacademy.springbootminidooray3gateway.domain;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @NotNull @NonNull
    private Long taskId;

    @NotNull @NonNull
    private String title;

    private String content;

    @NotNull @NonNull
    private String memberId;
}
