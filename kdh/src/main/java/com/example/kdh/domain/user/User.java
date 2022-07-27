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
                @UniqueConstraint(columnNames = {"id"})
        })
public class User extends EntityExtension {

    // 사용자 고유 ID
    @Id
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