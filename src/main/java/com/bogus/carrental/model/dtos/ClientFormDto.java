package com.bogus.carrental.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@Builder
public class ClientFormDto {

    private String name;
    private String surname;
    private String password;
    private String email;
    private String city;
    private String street;
    private String postCode;

}
