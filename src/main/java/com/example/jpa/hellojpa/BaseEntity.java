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
// 매핑 정보만 맞는 부모클래스
@MappedSuperclass
public class BaseEntity {
    @Column(name = "insert_member")
    private String createBy;
    private LocalDateTime createDate;
    @Column(name = "update_member")
    private String lastModifiedBy;
    private LocalDateTime lastModifiedDate;
}
