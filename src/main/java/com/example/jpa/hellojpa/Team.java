package com.example.jpa.hellojpa;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name = "Team")
public class Team {
    @Id @GeneratedValue
    @Column(name = "team_id")
    private Long id;
    private String name;

    // 양방향 매핑
    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();
}
