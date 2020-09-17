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

public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mark;
    private String model;
    private String bodyType;
    private Long mileage;
    private String color;
    private String productionYear;
    private Double payForDay;
    @OneToMany(mappedBy = "car")


    private List<Reservation> reservations;
    @OneToMany(mappedBy = "car")
    private List<CarStatus> statuses;

    @ManyToOne
    private Department department;
}
