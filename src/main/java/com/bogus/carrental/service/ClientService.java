package com.bogus.carrental.service;

import com.bogus.carrental.database.ClientRepository;
import com.bogus.carrental.model.Client;
import com.bogus.carrental.model.dtos.ClientDto;
import com.bogus.carrental.model.dtos.ClientMapper;
import com.bogus.carrental.model.dtos.SimpleClientDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientService {


    private final ClientRepository clientRepository;


    public List<ClientDto> findAll() {

        return (clientRepository.findAll().stream().map(ClientMapper::mapToClientDto).collect(Collectors.toList()));

    }


    public ClientDto findById(Long id) {

        return ClientMapper.mapToClientDto(
                clientRepository.findById(id)
                        .orElseThrow(NoSuchElementException::new));

    }


    public ClientDto addClient(Client client) {

        clientRepository.save(client);
        return ClientMapper.mapToClientDto(client);

    }


    public SimpleClientDto updateClient(SimpleClientDto simpleClientDto) {

        Client client = ClientMapper.mapDtoToClient(
                simpleClientDto,
                clientRepository.findById(simpleClientDto.getId())
                        .orElseThrow(NoSuchElementException::new));
        return ClientMapper.mapToSimpleClientDto(client);

    }


    public boolean deleteClient(Long id) {

        clientRepository.deleteById(id);
        return true;

    }
}
