package com.bogus.carrental.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "return_id")
    private CarReturn carReturn;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rental_id")
    private CarRental carRental;


}
