package com.example.jpa.hellojpa;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
// 매핑 정보만 가지는 부모클래스
// 상속 관계 매핑 x
// 엔티티 x
// 테이블과 매핑 x
// 부모 클래스를 상속 받는 자식 클래스에 매핑 정보만 제공
// 추상 클래스 권장
@MappedSuperclass
public abstract class BaseEntity {
    @Column(name = "insert_member")
    private String createBy;
    private LocalDateTime createDate;
    @Column(name = "update_member")
    private String lastModifiedBy;
    private LocalDateTime lastModifiedDate;
}
