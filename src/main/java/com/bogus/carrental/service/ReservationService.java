package com.bogus.carrental.service;

import com.bogus.carrental.database.ReservationRepository;
import com.bogus.carrental.model.Reservation;
import com.bogus.carrental.model.dtos.ReservationDto;
import com.bogus.carrental.model.dtos.ReservationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationService {


    private final ReservationRepository reservationRepository;


    public List<ReservationDto> findAllReservations() {

        return reservationRepository.findAll().stream().map(
                ReservationMapper::mapToReservationDto)
                .collect(Collectors.toList());

    }


    public ReservationDto createReservation(Reservation reservation) {

        reservationRepository.save(reservation);
        return ReservationMapper.mapToReservationDto(reservation);

    }


    public ReservationDto updateReservation(Long id, Reservation reservation) {

        Optional<Reservation> reservationById = reservationRepository.findById(id);
        Reservation updatedReservation = null;

        updatedReservation = reservationById.orElseThrow(NoSuchElementException::new);
        if (reservation.getCar() != null)
            updatedReservation.setCar((reservation).getCar());
        if (reservation.getClient() != null)
            updatedReservation.setClient((reservation).getClient());
        if (reservation.getDateOfReservation() != null)
            updatedReservation.setDateOfReservation(reservation.getDateOfReservation());
        if (reservation.getReservationStart() != null)
            updatedReservation.setReservationStart(reservation.getReservationStart());
        if (reservation.getReservationEnd() != null)
            updatedReservation.setReservationEnd(reservation.getReservationEnd());
        reservationRepository.save(updatedReservation);

        return ReservationMapper.mapToReservationDto(updatedReservation);

    }


    public void deleteReservationById(Long id) {

        reservationRepository.deleteById(id);

    }


    public ReservationDto showReservationById(Long id) {

        Optional<Reservation> reservationById = reservationRepository.findById(id);

        return ReservationMapper.mapToReservationDto(
                reservationById.orElseThrow(NoSuchElementException::new));


    }


}
