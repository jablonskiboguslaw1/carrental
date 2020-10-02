package com.bogus.carrental.model.dtos;


import com.bogus.carrental.model.Client;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component

public class ClientMapper {
    private ClientMapper() {
    }


    public static ClientDto clientToDto(Client client) {

        return ClientDto.builder().id(client.getId())
                .name(client.getName())
                .surname(client.getSurname())
                .city(client.getCity())
                .email(client.getEmail())
                .postCode(client.getPostCode())
                .street(client.getStreet())
                .build();

    }


    public static Client dtoToClient(ClientDto clientDto) {
        return Client.builder()
                .id(clientDto.getId())
                .name(clientDto.getName())
                .surname(clientDto.getSurname())
                .city(clientDto.getCity())
                .postCode(clientDto.getPostCode())
                .street(clientDto.getStreet())
                .isActive(clientDto.isActive())
                .build();

    }

    public static Client dtoToClient(ClientFormDto clientFormDto) {
        return Client.builder()
                .name(clientFormDto.getName())
                .password(new BCryptPasswordEncoder().encode(clientFormDto.getPassword()))
                .surname(clientFormDto.getSurname())
                .city(clientFormDto.getCity())
                .postCode(clientFormDto.getPostCode())
                .street(clientFormDto.getStreet())
                .email(clientFormDto.getEmail())
                .isActive(true)
                .build();

    }
}
