package com.nhnacademy.springbootminidooray3gateway.dto.request;

import com.nhnacademy.springbootminidooray3gateway.domain.ProjectState;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ModifyProjectStateRequest {
    @NonNull @NotNull
    private ProjectState state;
}
