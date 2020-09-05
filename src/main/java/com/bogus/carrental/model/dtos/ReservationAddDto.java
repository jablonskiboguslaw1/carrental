package com.bogus.carrental.model.dtos;

import java.time.LocalDate;

public class ReservationAddDto {


    private Long id;
    private LocalDate dateOfReservation;
    private Long car;
    private Long client;
    private LocalDate reservationStart;
    private LocalDate reservationEnd;
}
