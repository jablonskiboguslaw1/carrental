package com.bogus.carrental.model.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarUpdateDto {

    private Long mileage;
    private String color;
    private Double payForDay;

}
