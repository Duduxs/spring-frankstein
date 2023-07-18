package com.edudev.hateoas.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    public Long id;
    public String name;
    public Integer age;

    public Customer() {}

    public Customer(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
