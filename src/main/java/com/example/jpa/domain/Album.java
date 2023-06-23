package com.example.jpa.domain;

import com.example.jpa.hellojpa.Item;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

@Entity
@ToString
@Setter
@Getter
public class Album extends Item {
    private String artist;
    private String etc;
}
