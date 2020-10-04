package com.bogus.carrental.service;

import com.bogus.carrental.database.ClientRepository;
import com.bogus.carrental.model.Client;
import com.bogus.carrental.model.dtos.ClientDto;
import com.bogus.carrental.model.dtos.ClientFormDto;
import com.bogus.carrental.model.dtos.ClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ClientService {


    private final ClientRepository clientRepository;


    public List<ClientDto> findAllActiveClients() {
        return clientRepository.findAllActive().stream().map(ClientMapper::clientToDto).collect(Collectors.toList());
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


    public ClientDto updateClient(Long id, ClientFormDto clientFormDto) {

        Optional<Client> clientById = clientRepository.findById(id);
        Client updatedClient = null;

        updatedClient = clientById.orElseThrow(NoSuchElementException::new);
        if (clientFormDto.getName() != null)
            updatedClient.setName(clientFormDto.getName());
        if (clientFormDto.getSurname() != null)
            updatedClient.setSurname(clientFormDto.getSurname());
        if (clientFormDto.getCity() != null)
            updatedClient.setCity(clientFormDto.getCity());
        if (clientFormDto.getPostCode() != null)
            updatedClient.setPostCode(clientFormDto.getPostCode());
        if (clientFormDto.getStreet() != null)
            updatedClient.setStreet(clientFormDto.getStreet());
        if (clientFormDto.getEmail() != null)
            updatedClient.setEmail(clientFormDto.getEmail());
        clientRepository.save(updatedClient);

        return ClientMapper.clientToDto(updatedClient);
    }

    @Transactional
    public void deactivateClientAccountById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(NoSuchElementException::new);
        client.setActive(!client.isActive());
    }

    public ClientDto showClientByUsername(String username) {
       return ClientMapper.clientToDto(clientRepository.findByEmail(username));
    }
}
