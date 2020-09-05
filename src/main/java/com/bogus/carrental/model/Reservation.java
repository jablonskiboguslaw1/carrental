package com.bogus.carrental.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Reservation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDate dateOfReservation;

    @ManyToOne
    @JoinColumn(name = "car_id")

    private Car car;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    private LocalDate reservationStart;
    private LocalDate reservationEnd;
    @OneToOne()
    private CarReturn carReturn;

    public Car getCar() {
        return car;
    }
}
