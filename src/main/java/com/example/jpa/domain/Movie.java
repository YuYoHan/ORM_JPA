package com.example.jpa.domain;

import com.example.jpa.hellojpa.Item;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

@Entity
@ToString
@Getter
@Setter
public class Movie extends Item {
    private String director;
    private String actor;
}
