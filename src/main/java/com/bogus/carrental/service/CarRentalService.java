package com.bogus.carrental.service;

import com.bogus.carrental.database.CarRentalRepository;
import com.bogus.carrental.model.CarRental;
import com.bogus.carrental.model.Reservation;
import com.bogus.carrental.model.dtos.ReservationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarRentalService {

    private final CarRentalRepository carRentalRepository;
    private final ReservationService reservationService;

    public List<CarRental> findAll() {

        return carRentalRepository.findAll();
    }
@Transactional
    public CarRental makeRental(CarRental carRental, Long reservationId) {
    Reservation reservationById = reservationService.getReservationById(reservationId);
    reservationById.setCarRental(carRental);

        return carRental;
    }

    public CarRental  findFindById(Long id) {

       return carRentalRepository.findById(id).orElseThrow(NoSuchFieldError::new);
    }

    public boolean deleteRentalById(Long id) {

     carRentalRepository.deleteById(id);
     return true;


    }
}
