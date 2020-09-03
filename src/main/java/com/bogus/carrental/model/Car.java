package com.bogus.carrental.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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


    public List<Reservation> getReservations() {
        return reservations;
    }
}
