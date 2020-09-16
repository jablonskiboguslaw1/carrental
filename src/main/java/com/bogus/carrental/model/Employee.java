package com.bogus.carrental.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Employee extends User{

    @OneToMany(mappedBy = "employee")
    List<CarRental> rentals;
    @OneToMany(mappedBy = "employee")
    List<CarReturn> returns;

    @Enumerated (EnumType.STRING)
    private Position position;
   @ManyToOne
    private Department department;
}
