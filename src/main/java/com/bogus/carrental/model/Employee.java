package com.bogus.carrental.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "employee")
    List<CarRental> rentals;
    @OneToMany(mappedBy = "employee")
    List<CarReturn> returns;
    private String name;
    private String surname;
    private String email;

    @Enumerated(EnumType.STRING)
    private Position position;
    @ManyToOne
    private Department department;
    private String password;
}
