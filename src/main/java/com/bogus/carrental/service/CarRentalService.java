package com.bogus.carrental.service;

import com.bogus.carrental.database.CarRentalRepository;
import com.bogus.carrental.database.EmployeeRepository;
import com.bogus.carrental.database.ReservationRepository;
import com.bogus.carrental.model.CarRental;
import com.bogus.carrental.model.Employee;
import com.bogus.carrental.model.Reservation;
import com.bogus.carrental.model.dtos.CarRentalDto;
import com.bogus.carrental.model.dtos.CarRentalMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarRentalService {

    private final CarRentalRepository carRentalRepository;
    private final ReservationService reservationService;
    private final ReservationRepository reservationRepository;
    private final EmployeeRepository employeeRepository;

    public List<CarRentalDto> findAll() {

        return carRentalRepository.findAll().stream().map(CarRentalMapper::mapToDto).collect(Collectors.toList());
    }


    public List<CarRentalDto> findAllByEmployee(Long id) {

        return carRentalRepository.findAllByEmployee(id).stream().map(CarRentalMapper::mapToDto).collect(Collectors.toList());
    }

    @Transactional
    public CarRentalDto makeRental(CarRentalDto carRentalDto, Long reservationId) {
        Reservation reservationById = reservationService.getReservationById(reservationId);
        Employee employee = employeeRepository.findById(carRentalDto.getEmployeeId()).orElseThrow(NoSuchElementException::new);
        reservationById.setCarRental(CarRentalMapper.mapDtoToCarRental(carRentalDto, employee));
        return CarRentalMapper.mapToDto(reservationById.getCarRental());
    }

    public CarRentalDto findFindById(Long id) {
        return CarRentalMapper.mapToDto(carRentalRepository.findById(id).orElseThrow(NoSuchFieldError::new));
    }

    public boolean deleteRentalById(Long id) {
        carRentalRepository.deleteById(id);
        return true;

    }

    @Transactional
    public boolean deleteRentalByReservationId(Long id) {
        reservationRepository.findById(id).orElseThrow(NoSuchElementException::new).setCarRental(null);
        return true;
    }
}
