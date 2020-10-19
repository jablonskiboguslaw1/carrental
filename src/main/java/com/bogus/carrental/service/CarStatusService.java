package com.bogus.carrental.service;

import com.bogus.carrental.database.CarStatusRepository;
import com.bogus.carrental.model.Car;
import com.bogus.carrental.model.CarStatus;
import com.bogus.carrental.model.dtos.CarStatusDto;
import com.bogus.carrental.model.dtos.CarStatusMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarStatusService {

    private final CarStatusRepository carStatusRepository;



    public CarStatus updateStatuses(CarStatus carStatus, Car car){

        carStatus.setCar(car);
        carStatusRepository.save(carStatus);
        return carStatus;


    }

}
