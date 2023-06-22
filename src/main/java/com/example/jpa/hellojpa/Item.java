package com.example.jpa.hellojpa;

import javax.persistence.*;

@Entity
// 조인 전략
@Inheritance(strategy = InheritanceType.JOINED)
// 부모 클래스에 선언
// 하위 클래스를 구분하는 용도의 컬럼
// DTYPE
@DiscriminatorColumn
public class Item {
    @Id @GeneratedValue
    private  Long id;

    private String name;
    private int price;
}
