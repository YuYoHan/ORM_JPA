package com.example.jpa.hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "member_ex")
@Table(name = "MBR")
public class Member {

    @Id
    private Long id;

    @Column(name = "name")
    private String userName;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    // 날짜 타입(java.util.Date, java.util.Calendar)을 매핑할 때 사용
    // LocalDate, LocalDateTime을 사용할 때는 생략 가능
    // TemporalType.TIMESTAMP : 날짜와 시간, 데이터베이스 timestamp 타입과 매핑
    // 예) 2023-05-08 11:11:11
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    // 데이터베이스 BLOB, CLOB 타입과 매핑
    // DB에 큰 데이터를 넣고 싶으면 @Lob 사용
    @Lob
    private String description;

    public Member() {
    }
}
