package com.example.jpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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

}
