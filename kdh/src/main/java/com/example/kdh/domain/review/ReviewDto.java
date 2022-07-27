package com.example.kdh.domain.review;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ReviewDto {
    // 리뷰 idx
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
