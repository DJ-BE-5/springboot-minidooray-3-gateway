package com.nhnacademy.springbootminidooray3gateway.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class AddMemberRequest {
    String memberId;
}
