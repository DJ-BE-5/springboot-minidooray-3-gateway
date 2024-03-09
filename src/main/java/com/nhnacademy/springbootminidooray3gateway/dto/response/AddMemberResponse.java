package com.nhnacademy.springbootminidooray3gateway.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class AddMemberResponse {
    Long projectId;
    String memberId;
}
