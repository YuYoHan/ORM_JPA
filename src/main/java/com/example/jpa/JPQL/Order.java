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
@Table(name = "orders")
public class Order {
    @Id @GeneratedValue
    private Long id;
    private int orderAmount;
    @Embedded
    private Address address;

    // 연관관계의 주인은 fk가 있는 곳이다.
    // 즉, 외부키가 있는 곳이 주인이다.
    // 보통 '다'쪽이 외부키가 있는 곳이다.
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
