package com.bogus.carrental.model.dtos;

import com.bogus.carrental.model.Car;
import com.bogus.carrental.model.Client;
import com.bogus.carrental.model.Reservation;

public class ReservationMapper {

    private ReservationMapper() {
    }


    public static ReservationDto mapToReservationDto(Reservation reservation) {

        return
                ReservationDto.builder()
                        .id(reservation.getId())
                        .dateOfReservation(reservation.getDateOfReservation())
                        .reservationStart(reservation.getReservationStart())
                        .reservationEnd(reservation.getReservationEnd())
                        .client(ClientMapper.clientToDto(reservation.getClient()))
                        .car(CarMapper.mapToCarDto(reservation.getCar()))
                        .carRental(CarRentalMapper.mapToDto(reservation.getCarRental()))
                        .carReturn(CarReturnMapper.mapToDto(reservation.getCarReturn()))
                        .build();
    }

    public static Reservation mapDtoFormToReservation(ReservationFormDto reservationFormDto, Car car, Client client) {
        return Reservation.builder().client(client)
                .car(car)
                .reservationStart(reservationFormDto.getReservationStart())
                .reservationEnd(reservationFormDto.getReservationEnd())
                .build();
    }

}
