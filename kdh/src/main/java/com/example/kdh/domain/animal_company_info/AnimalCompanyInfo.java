package com.example.kdh.domain.animal_company_info;

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
@Table(name = "animal_company_info",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"id"})
        })
public class AnimalCompanyInfo extends EntityExtension {

    // 병원 고유 ID
    @Id
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
