package com.example.jpa.hellojpa;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String city;
    private String street;
    private String zipcode;
}
