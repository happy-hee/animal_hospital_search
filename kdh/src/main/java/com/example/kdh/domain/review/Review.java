package com.example.kdh.domain.review;

import com.example.kdh.domain.EntityExtension;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "review",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"id"})
        })

public class Review extends EntityExtension {
    // 리뷰 idx
    @Id
    private Long reviewIdx;

    // 병원 고유 ID
    private String companyId;

    // 사용자 고유 ID
    private String userId;

    // 평점
    private Float rating;

    // 내용
    private String contents;

    // 작성일
    private LocalDateTime writeDateTime;

    // 생성 시간
    private LocalDateTime createdDateTime;

    // 수정 시간
    private LocalDateTime modifiedDateTime;
}
