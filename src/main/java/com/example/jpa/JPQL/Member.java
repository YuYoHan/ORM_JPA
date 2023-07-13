package com.example.jpa.JPQL;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue
    private Long id;

    private String userName;
    private int age;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @Builder
    public Member(Long id, String userName, int age) {
        this.id = id;
        this.userName = userName;
        this.age = age;
    }
}
