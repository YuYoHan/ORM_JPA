package com.example.jpa.hellojpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Locker {
    @Id @GeneratedValue
    private Long id;

    private String name;

    // 일대일 양방향을 하기 위해서
    // mappedBy="locker"을 해준다.
    @OneToOne(mappedBy = "locker")
    private Member member;
}
