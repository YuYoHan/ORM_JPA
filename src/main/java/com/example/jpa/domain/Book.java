package com.example.jpa.domain;

import com.example.jpa.hellojpa.Item;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

@Entity
@Setter
@Getter
@ToString
public class Book extends Item {
    private String author;
    private String name;
    private String isbn;
}
