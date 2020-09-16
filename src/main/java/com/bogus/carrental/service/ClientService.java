package com.bogus.carrental.service;

import com.bogus.carrental.database.ClientRepository;
import com.bogus.carrental.model.Client;
import com.bogus.carrental.model.dtos.ClientDto;
import com.bogus.carrental.model.dtos.ClientFormDto;
import com.bogus.carrental.model.dtos.ClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ClientService {


    private final ClientRepository clientRepository;


    public List<ClientDto> showAllClients() {

        return clientRepository.findAll().stream().map(ClientMapper::clientToDto).collect(Collectors.toList());

    }


    public ClientDto showClientById(Long id) {

        Optional<Client> clientOptional = clientRepository.findById(id);
        if (clientOptional.isPresent())
            return ClientMapper.clientToDto(clientOptional.get());
        else throw new NoSuchElementException();

    }


    public ClientFormDto createClient(ClientFormDto client) {

        clientRepository.save(ClientMapper.dtoToClient(client));
        return client;

    }


    public ClientDto updateClient(Long id, ClientDto clientDto) {

        Optional<Client> clientById = clientRepository.findById(id);
        Client updatedClient = null;

        updatedClient = clientById.orElseThrow(NoSuchElementException::new);
        if (clientDto.getName() != null)
            updatedClient.setName(clientDto.getName());
        if (clientDto.getSurname() != null)
            updatedClient.setSurname(clientDto.getSurname());
        if (clientDto.getCity() != null)
            updatedClient.setCity(clientDto.getCity());
        if (clientDto.getPostCode() != null)
            updatedClient.setPostCode(clientDto.getPostCode());
        if (clientDto.getStreet() != null)
            updatedClient.setStreet(clientDto.getStreet());
        if (clientDto.getEmail() != null)
            updatedClient.setEmail(clientDto.getEmail());
        clientRepository.save(updatedClient);

        return ClientMapper.clientToDto(updatedClient);
    }


    public void deleteClientById(Long id) {

        clientRepository.deleteById(id);

    }

    public Client findClientById(Long id) {

        return clientRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
