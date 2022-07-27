package com.example.kdh.domain.business_hours;

import lombok.*;

import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class BusinessHoursDto {
    // 영업시간 idx
    @Id
    private Long bhIdx;

    // 병원 고유 ID
    private String companyId;

    // 24시 영업 여부
    private Boolean open24Hours;

    // 월요일 영업 여부
    private Boolean mondayOpen;

    // 월요일 영업 시작 시간
    private LocalDateTime mondayStartTime;

    // 월요일 영업 마감 시간
    private LocalDateTime mondayEndTime;

    // 화요일 영업 여부
    private Boolean tuesdayOpen;

    // 화요일 영업 시작 시간
    private LocalDateTime tuesdayStartTime;

    // 화요일 영업 마감 시간
    private LocalDateTime tuesdayEndTime;

    // 수요일 영업여부
    private Boolean wednesdayOpen;

    // 수요일 영업 시작 시간
    private LocalDateTime wednesdayStartTime;

    // 수요일 영업 마감 시간
    private LocalDateTime wednesdayEndTime;

    // 목요일 영업 여부
    private Boolean thursdayOpen;

    // 목요일 영업 시작 시간
    private LocalDateTime thursdayStartTime;

    // 목요일 영업 마감 시간
    private LocalDateTime thursdayEndTime;

    // 금요일 영업 여부
    private Boolean fridayOpen;

    // 금요일 영업 시작 시간
    private LocalDateTime fridayStartTime;

    // 금요일 영업 마감 시간
    private LocalDateTime fridayEndTime;

    // 토요일 영업 여부
    private Boolean saturdayOpen;

    // 토요일 영업 시작 시간
    private LocalDateTime saturdayStartTime;

    // 토요일 영업 마감 시간
    private LocalDateTime saturdayEndTime;

    // 일요일 영업 여부
    private Boolean sundayOpen;

    // 일요일 영업 시작 시간
    private LocalDateTime sundayStartTime;

    // 일요일 영업 마감 시간
    private LocalDateTime sundayEndTime;

    // 월요일 점심 시작 시간
    private LocalDateTime mondayLunchStartTime;

    // 월요일 점심 마감 시간
    private LocalDateTime mondayLunchEndTime;

    // 화요일 점심 시작 시간
    private LocalDateTime tuesdayLunchStartTime;

    // 화요일 점심 마감 시간
    private LocalDateTime tuesdayLunchEndTime;

    // 수요일 점심 시작 시간
    private LocalDateTime wednesdayLunchStartTime;

    // 수요일 점심 마감 시간
    private LocalDateTime wednesdayLunchEndTime;

    // 목요일 점심 시작 시간
    private LocalDateTime thursdayLunchStartTime;

    // 목요일 점심 마감 시간
    private LocalDateTime thursdayLunchEndTime;

    // 금요일 점심 시작 시간
    private LocalDateTime fridayLunchStartTime;

    // 금요일 점심 마감 시간
    private LocalDateTime fridayLunchEndTime;

    // 토요일 점심 시작 시간
    private LocalDateTime saturdayLunchStartTime;

    // 토요일 점심 마감 시간
    private LocalDateTime saturdayLunchEndTime;

    // 일요일 점심 시작 시간
    private LocalDateTime sundayLunchStartTime;

    // 일요일 점심 마감 시간
    private LocalDateTime sundayLunchEndTime;

    // 생성 시간
    private LocalDateTime createdDateTime;

    // 수정 시간
    private LocalDateTime modifiedDateTime;
}
