package com.example.kdh.domain.user;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class UserDto {

    // 사용자 고유 ID
    private String userId;

    // 사용자 ID
    private String id;

    // 비밀번호
    private String password;

    // 사용자 이메일
    private String email;

    // 연락처
    private String phone;

}
