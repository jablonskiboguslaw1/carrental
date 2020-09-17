package com.bogus.carrental.model.dtos;


import com.bogus.carrental.model.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component

public class ClientMapper {
    private ClientMapper(){}



    public static ClientDto clientToDto(Client client){

       return ClientDto.builder().id(client.getId())
                .name(client.getName())
                .surname(client.getSurname())
                .city(client.getCity())
                .email(client.getEmail())
                .postCode(client.getPostCode())
                .street(client.getStreet())
                .build();

    }


    public static Client dtoToClient(ClientDto clientDto){
        Client build = Client.builder()

                .city(clientDto.getCity())
                .postCode(clientDto.getPostCode())
                .street(clientDto.getStreet())
                .build();
        build.setSurname(clientDto.getSurname());
        build.setName(clientDto.getName());
        return build;

    }
    public static Client dtoToClient(ClientFormDto clientFormDto){
        Client build = Client.builder()

                .city(clientFormDto.getCity())
                .postCode(clientFormDto.getPostCode())
                .street(clientFormDto.getStreet())
                .email(clientFormDto.getEmail())
                .build();
        build.setName(clientFormDto.getName());
        build.setSurname(clientFormDto.getSurname());
        build.setPassword(new BCryptPasswordEncoder().encode(clientFormDto.getPassword()));
return build;
    }
}
