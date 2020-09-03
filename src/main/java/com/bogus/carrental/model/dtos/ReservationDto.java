package com.bogus.carrental.model.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReservationDto {

    private Long id;
    private LocalDate dateOfReservation;
    private CarDto car;
    private ClientDto client;
    private LocalDate reservationStart;
    private LocalDate reservationEnd;
}
