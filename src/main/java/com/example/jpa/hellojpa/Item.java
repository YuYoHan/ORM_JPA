package com.example.jpa.hellojpa;

import javax.persistence.*;

@Entity
// 단일 테이블 전략
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
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
