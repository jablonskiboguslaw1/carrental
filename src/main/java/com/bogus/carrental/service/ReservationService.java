package com.bogus.carrental.service;

import com.bogus.carrental.database.ReservationRepository;
import com.bogus.carrental.model.Income;
import com.bogus.carrental.model.Reservation;
import com.bogus.carrental.model.dtos.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
@RequiredArgsConstructor
public class ReservationService {
    public static final String RESERVATION = "RENTAL";
    public static final String RESERVATION_CANCELING = "RENTAL_CANCELING";
    public static final double LATE_CANCELING_RATIO = 0.8;

    private final ReservationRepository reservationRepository;
    private final IncomeService incomeService;
    private final CarService carService;
    private final ClientService clientService;

    public List<ReservationDto> findAllReservations() {

        return reservationRepository.findAll().stream().map(
                ReservationMapper::mapToReservationDto)
                .collect(Collectors.toList());

    }


    public ReservationDto createReservation(ReservationFormDto reservationFormDto) {

        Reservation reservation = reservationRepository.save(ReservationMapper.mapDtoFormToReservation(reservationFormDto,
                carService.showCarById(reservationFormDto.getCar()),
                clientService.findClientById(reservationFormDto.getClient())));
        incomeService.addIncomeEntry(new Income((getReservationCost(reservation) * LATE_CANCELING_RATIO), RESERVATION));
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
        reservationRepository.save(updatedReservation);

        return ReservationMapper.mapToReservationDto(updatedReservation);

    }


    public void deleteReservationById(Long id) {
        Reservation reservation = findById(id);
        if (reservation.getReservationStart().isBefore(LocalDate.now().minusDays(2))) {
            incomeService.addIncomeEntry(new Income((0 - getReservationCost(findById(id))), RESERVATION_CANCELING));
        } else
            incomeService.addIncomeEntry(new Income(((0 - getReservationCost(findById(id))) * LATE_CANCELING_RATIO), RESERVATION_CANCELING));

        reservationRepository.deleteById(id);

    }


    public ReservationDto showReservationById(Long id) {

        Optional<Reservation> reservationById = reservationRepository.findById(id);

        return ReservationMapper.mapToReservationDto(
                reservationById.orElseThrow(NoSuchElementException::new));


    }

    public Reservation findById(Long id) {
        return reservationRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    private Double getReservationCost(Reservation reservation) {

        return DAYS.between(reservation.getReservationStart(), reservation.getReservationEnd().plusDays(1)) * reservation.getCar().getPayForDay();
    }


}
