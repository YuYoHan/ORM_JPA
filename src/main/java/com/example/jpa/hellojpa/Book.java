package com.example.jpa.hellojpa;

import javax.persistence.Entity;

@Entity
public class Book extends Item{
    private String author;
    private String isbn;

}
