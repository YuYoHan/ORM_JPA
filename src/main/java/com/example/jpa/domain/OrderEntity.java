package com.example.jpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "Orders")
public class OrderEntity {
    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

//    @Column(name = "member_id")
//    private Long memberId;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
