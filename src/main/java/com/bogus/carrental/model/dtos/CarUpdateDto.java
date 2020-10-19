package com.bogus.carrental.model.dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CarUpdateDto {

    private Long mileage;
    private String color;
    private BigDecimal payForDay;

}
