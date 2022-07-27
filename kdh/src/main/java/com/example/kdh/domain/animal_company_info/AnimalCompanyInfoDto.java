package com.example.kdh.domain.animal_company_info;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class AnimalCompanyInfoDto {
    // 병원 고유 ID
    private String companyId;

    // 병원 이름
    private String name;

    // 소재지(도로명)
    private String address;

    // 연락처
    private String phone;

    // 위도
    private Double lat;

    // 경도
    private Double lng;

    // 대표자
    private String representative;

    // 수의사 수
    private Integer numberOfEmployee;

    // 전문 분야
    private String specialField;

    // 특수동물 진료 가능 여부
    private Boolean specialAnimalYn;

    // 주차가능 여부
    private Boolean parkingYn;

    // 생성 시간
    private LocalDateTime createdDateTime;

    // 수정 시간
    private LocalDateTime modifiedDateTime;
}
