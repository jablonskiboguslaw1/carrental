package com.bogus.carrental.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
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
    private BigDecimal payForDay;
    @OneToMany(mappedBy = "car")


    private List<Reservation> reservations;
    @OneToMany(mappedBy = "car")
    private List<CarStatus> statuses;

    @ManyToOne
    private Department department;
}
