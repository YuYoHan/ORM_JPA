package com.example.jpa.hellojpa;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
// 자식 클래스에서 DTYPE이 어떻게 넣어야할지 가이드
@DiscriminatorValue("A")
public class Album  extends Item{
    private String artist;
}
