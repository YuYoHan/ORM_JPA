package com.example.jpa.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class Delivery {
    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private Address address;
    private DeliveryStatus status;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private OrderEntity order;

    @Builder
    public Delivery(Long id, Address address, DeliveryStatus status, OrderEntity order) {
        this.id = id;
        this.address = address;
        this.status = status;
        this.order = order;
    }
}
