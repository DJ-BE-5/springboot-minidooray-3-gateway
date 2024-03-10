package com.nhnacademy.springbootminidooray3gateway.domain;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Task implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull @NonNull
    private Long taskId;

    @NotNull @NonNull
    private String title;

    private String content;

    @NotNull @NonNull
    private String memberId;
}
