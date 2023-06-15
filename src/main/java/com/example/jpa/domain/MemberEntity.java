package com.example.jpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Member")
public class MemberEntity {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String name;
    private String city;
    private String street;
    private String zipcode;

    // Order에서 단방향 처리한 것을 양방향으로 바꾸고 싶을 때
    // mappedBy = "member"는 OrderEntity에 있는 member가 주인이라는 뜻
    @OneToMany(mappedBy = "member")
    private List<OrderEntity> orders = new ArrayList<>();
}
