package com.example.kdh.domain.user;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class UserDto {

    // 회원 IDX
    private String urIdx;

    // 이메일
    private String email;

    // 패스워드
    private String password;

    // 관리자 여부
    private boolean adminYn;

}
