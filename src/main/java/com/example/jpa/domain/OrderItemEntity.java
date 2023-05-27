package com.example.jpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "OrderItem")
@Getter
@Setter
public class OrderItemEntity {
    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "item_id")
    private Long itemId;

}
