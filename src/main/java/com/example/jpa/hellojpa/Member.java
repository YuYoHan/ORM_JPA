package com.example.jpa.hellojpa;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity(name = "member_ex")
@Table(name = "MBR")
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "member_seq_generator")
public class Member extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(name = "user_name", nullable = false)
    private String userName;

    // 기간
    @Embedded
    private Period workPeriod;

    // 주소
    @Embedded
    private Address homeAddress;
}
