package com.example.jpa.hellojpa;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Item {
    @Id @GeneratedValue
    private  Long id;

    private String name;
    private int price;
}
