package com.example.jpa.JPQL;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@ToString
@Getter
@NoArgsConstructor
public class Product {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private int price;
    private int stockAmount;

    @Builder
    public Product(Long id, String name, int price, int stockAmount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockAmount = stockAmount;
    }
}
