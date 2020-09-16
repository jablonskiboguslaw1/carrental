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
                .employee(EmployeeMapper.mapToDto(carRental.getEmployee()))
                .comments(carRental.getComments()).build();
    }

    public static CarRental mapDtoToCarRental(String comment, Employee employee) {
        return CarRental.builder()
                .comments(comment)
                .employee(employee).build();

    }


}



