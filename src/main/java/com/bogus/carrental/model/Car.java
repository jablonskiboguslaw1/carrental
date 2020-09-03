package com.bogus.carrental.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
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
    @OneToMany (mappedBy = "car")
    private List<Reservation> reservations;
    @OneToMany (mappedBy = "car")
    private List<CarStatus> statuses;
}
