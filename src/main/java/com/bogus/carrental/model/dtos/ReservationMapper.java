package com.bogus.carrental.model.dtos;

import com.bogus.carrental.model.Car;
import com.bogus.carrental.model.Reservation;

import java.util.List;
import java.util.stream.Collectors;

public class ReservationMapper {

private ReservationMapper(){}



    public static ReservationDto mapToReservationDto(Reservation reservation) {

        return
                ReservationDto.builder()
                        .id(reservation.getId())
                        .dateOfReservation(reservation.getDateOfReservation())
                        .reservationStart(reservation.getReservationStart())
                        .reservationEnd(reservation.getReservationEnd())
                        .car(CarMapper.mapToCarDto(reservation.getCar())).build();
    }


}
