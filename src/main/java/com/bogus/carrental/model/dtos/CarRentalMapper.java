package com.bogus.carrental.model.dtos;

import com.bogus.carrental.model.CarRental;

public class CarRentalMapper {




    public static CarRentalDto mapToDto(CarRental carRental){
        if(carRental==null)
            return null;
    return CarRentalDto.builder()
            .id(carRental.getId())
            .dateOfRental(carRental.getDateOfRental())
            .employee(EmployeeMapper.mapToDto(carRental.getEmployee()))
            .comments(carRental.getComments()).build();}
}
