package com.bogus.carrental.model.dtos;

import com.bogus.carrental.model.Client;

import java.util.stream.Collectors;

public class ClientMapper {


    private ClientMapper(){}


    public static ClientDto mapToClientDto(Client client) {
        return ClientDto.builder()
                .id(client.getId())
                .name(client.getName())
                .surname(client.getSurname())
                .city(client.getCity())
                .street(client.getStreet())
                .postCode(client.getPostCode())
                .email(client.getEmail())
                .reservations(
                        client.getReservations()
                        .stream()
                        .map(ReservationMapper::mapToReservationDto)
                                .collect(Collectors.toList()))
                .build();
    }
    public static SimpleClientDto mapToSimpleClientDto(Client client) {
        return SimpleClientDto.builder()
                .id(client.getId())
                .surname(client.getSurname())
                .city(client.getCity())
                .street(client.getStreet())
                .postCode(client.getPostCode())
                .email(client.getEmail())
                .build();
    }

    public static Client mapDtoToClient(SimpleClientDto simpleClientDto, Client client) {
        if (simpleClientDto.getSurname()!=null)
            client.setSurname(simpleClientDto.getSurname());
        if (simpleClientDto.getCity()!=null)
            client.setCity(simpleClientDto.getCity());
        if (simpleClientDto.getStreet()!=null)
            client.setStreet(simpleClientDto.getStreet());
        if (simpleClientDto.getEmail()!=null)
            client.setEmail(simpleClientDto.getEmail());
        if (simpleClientDto.getPostCode()!=null)
            client.setPostCode(simpleClientDto.getPostCode());
      return client;

    }
}
