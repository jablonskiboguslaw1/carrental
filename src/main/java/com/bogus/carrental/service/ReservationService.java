package com.bogus.carrental.service;

import com.bogus.carrental.database.ReservationRepository;
import com.bogus.carrental.model.Reservation;
import com.bogus.carrental.model.dtos.CarMapper;
import com.bogus.carrental.model.dtos.ClientMapper;
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


    public ReservationDto updateReservation(Long id, ReservationDto reservationDto) {

        Optional<Reservation> reservationById = reservationRepository.findById(id);
        Reservation updatedReservation = null;

        updatedReservation = reservationById.orElseThrow(NoSuchElementException::new);
        if (reservationDto.getCar() != null)
            updatedReservation.setCar(CarMapper.mapDtoToCar((reservationDto).getCar()));
        if (reservationDto.getClient() != null)
            updatedReservation.setClient(ClientMapper.dtoToClient((reservationDto).getClient()));
        if (reservationDto.getDateOfReservation() != null)
            updatedReservation.setDateOfReservation(reservationDto.getDateOfReservation());
        if (reservationDto.getReservationStart() != null)
            updatedReservation.setReservationStart(reservationDto.getReservationStart());
        if (reservationDto.getReservationEnd() != null)
            updatedReservation.setReservationEnd(reservationDto.getReservationEnd());
        if(reservationDto.getCarRental()!=null)
            updatedReservation.setCarRental(reservationDto.getCarRental());
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
    public Reservation getReservationById(Long id){
        return  reservationRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }


}
