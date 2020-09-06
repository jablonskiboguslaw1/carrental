package com.bogus.carrental.model.dtos;

import com.bogus.carrental.model.Reservation;

public class ReservationMapper {

private ReservationMapper(){}



    public static ReservationDto mapToReservationDto(Reservation reservation) {

        return
                ReservationDto.builder()
                        .id(reservation.getId())
                        .dateOfReservation(reservation.getDateOfReservation())
                        .reservationStart(reservation.getReservationStart())
                        .reservationEnd(reservation.getReservationEnd())
                        .client(ClientMapper.clientToDto(reservation.getClient()))
                        .car(CarMapper.mapToCarDto(reservation.getCar()))
                        .carRental(reservation.getCarRental())
                        .carReturn(reservation.getCarReturn())
                        .build();
    }


}
