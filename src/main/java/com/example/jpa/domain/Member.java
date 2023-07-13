package com.example.jpa.domain;

import com.example.jpa.hellojpa.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@ToString
@Getter
public class Member extends BaseEntity {
    @Id @GeneratedValue
    private Long id;
    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")
    private List<OrderEntity> orders = new ArrayList<>();

    @Builder
    public Member(Long id, String name, Address address, List<OrderEntity> orders) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.orders = orders;
    }
}
