package com.bogus.carrental.model.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder

public class ReservationDto {

    private Long id;
    private LocalDate dateOfReservation;
    private CarDto car;
    private ClientDto client;
    private LocalDate reservationStart;
    private LocalDate reservationEnd;
    private CarReturnDto carReturn;
    private CarRentalDto carRental;
}
