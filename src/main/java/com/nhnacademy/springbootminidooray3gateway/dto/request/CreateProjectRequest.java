package com.nhnacademy.springbootminidooray3gateway.dto.request;

import com.nhnacademy.springbootminidooray3gateway.domain.State;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CreateProjectRequest {
    @NonNull @NotNull
    private String title;

    private String content;

    @NonNull @NotNull
    private State state;
}
