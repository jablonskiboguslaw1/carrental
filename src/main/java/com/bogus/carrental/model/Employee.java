package com.bogus.carrental.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
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

    @Enumerated (EnumType.STRING)
    private Position position;
   @ManyToOne
    private Department department;
}
