package com.bogus.carrental.model.dtos;

import com.bogus.carrental.model.CarRental;
import com.bogus.carrental.model.Employee;

public class CarRentalMapper {


    public static CarRentalDto mapToDto(CarRental carRental) {
        if (carRental == null)
            return null;
        return CarRentalDto.builder()
                .id(carRental.getId())
                .dateOfRental(carRental.getDateOfRental())
                .employeeId(carRental.getEmployee().getId())
                .comments(carRental.getComments()).build();
    }

    public static CarRental mapDtoToCarRental(CarRentalDto carRental, Employee employee) {
        return CarRental.builder()
                .employee(employee)
                .comments(carRental.getComments())
                .dateOfRental(carRental.getDateOfRental())
                .id(carRental.getId())
                .build();

    }
}
