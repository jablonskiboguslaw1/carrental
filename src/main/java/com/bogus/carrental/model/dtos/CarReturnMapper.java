package com.bogus.carrental.model.dtos;

import com.bogus.carrental.model.CarReturn;
import com.bogus.carrental.model.Employee;

public class CarReturnMapper {

    private CarReturnMapper() {
    }


    public static CarReturnDto mapToDto(CarReturn carReturn) {
        if (carReturn == null)
            return null;
        return CarReturnDto.builder()
                .id(carReturn.getId())
                .dateOfReturn(carReturn.getDateOfReturn())
                .employeeId(carReturn.getEmployee().getId())
                .comments(carReturn.getComments())
                .additionalPayments(carReturn.getAdditionalPayments().toString()).build();
    }

    public static CarReturn mapDtoToCarReturn(CarReturnDto carReturnFormDto, Employee employee) {
        return CarReturn.builder()
                .comments(carReturnFormDto.getComments())
                .employee(employee).
                        additionalPayments(Double.parseDouble(carReturnFormDto.getAdditionalPayments())).build();

    }

}
