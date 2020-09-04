package com.bogus.carrental.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "employee")
    List<CarRental> rentals;
    @OneToMany(mappedBy = "employee")
    List<CarReturn> returns;
}
