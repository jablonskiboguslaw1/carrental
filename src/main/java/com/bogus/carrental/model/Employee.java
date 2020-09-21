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
<<<<<<< HEAD
public class Employee extends UserEntity {

=======
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
>>>>>>> parent of 957e9bd... inheritanece looks good
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
