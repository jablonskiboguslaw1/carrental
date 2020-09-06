package com.bogus.carrental.model.dtos;


import com.bogus.carrental.model.Reservation;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class ClientDto {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private String city;
    private String street;
    private String postCode;

}
