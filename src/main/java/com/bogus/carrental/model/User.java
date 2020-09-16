package com.bogus.carrental.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;

@Inheritance
@Getter
@Setter
@NoArgsConstructor
@Entity
@AllArgsConstructor

public abstract class User {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    private String password;
}
