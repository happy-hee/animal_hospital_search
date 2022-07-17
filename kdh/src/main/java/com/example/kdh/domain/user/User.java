package com.example.kdh.domain.user;

import com.example.kdh.domain.EntityExtension;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "user",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"email"})
        })
public class User extends EntityExtension {

    // 회원 IDX
    @Id
    private String urIdx;

    // 이메일
    private String email;

    // 패스워드
    private String password;

    // 관리자 여부
    private boolean adminYn;

}