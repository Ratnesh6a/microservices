package com.example.address.address.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Address {

    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Long id;

    private  String street;

    private String city;

}
