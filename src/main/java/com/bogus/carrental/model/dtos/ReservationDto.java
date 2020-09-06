package com.bogus.carrental.model.dtos;

import com.bogus.carrental.model.CarRental;
import com.bogus.carrental.model.CarReturn;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.OneToOne;
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
    private CarReturn carReturn;
    private CarRental carRental;
}
