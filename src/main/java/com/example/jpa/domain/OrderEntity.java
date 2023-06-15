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

    // 주문에 입장에서는 주문을 여러개 넣을 수 있으니
    // @ManyToOne
    @ManyToOne
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
