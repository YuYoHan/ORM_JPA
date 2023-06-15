package com.example.jpa.hellojpa;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "member_ex")
@Table(name = "MBR")
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "member_seq_generator")
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(name = "user_name", nullable = false)
    private String userName;

//    @Column(name = "team_id")
//    private Long teamId;

    // member입장에서는 many고 team은 one이다.
    // 하나의 팀에 여러명의 멤버가 들어갈 수 있기 때문
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

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


    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }
}
