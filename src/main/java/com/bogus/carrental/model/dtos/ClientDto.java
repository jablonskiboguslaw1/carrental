package com.bogus.carrental.model.dtos;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

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
