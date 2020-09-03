package com.bogus.carrental.model.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientDto {



    private Long id;
    private String name;
    private String surname;
    private String email;
    private String city;
    private String street;
    private String postCode;
    private List<ReservationDto> reservations;
}
