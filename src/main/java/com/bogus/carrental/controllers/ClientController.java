package com.bogus.carrental.controllers;

import com.bogus.carrental.model.Client;
import com.bogus.carrental.model.dtos.ClientDto;
import com.bogus.carrental.model.dtos.SimpleClientDto;
import com.bogus.carrental.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {


    private final ClientService clientService;


    @GetMapping("")
    public List<ClientDto> findAll() {

        return clientService.findAll();

    }


    @GetMapping("/details")
    public ClientDto findById(@RequestParam Long id) {

        return clientService.findById(id);

    }


    @PostMapping("")
    @ResponseBody
    public ClientDto addClient(@RequestBody Client client) {

        return clientService.addClient(client);

    }


    @PatchMapping("")
    public SimpleClientDto updateClientData(@RequestBody SimpleClientDto simpleClientDto){

        return clientService.updateClient(simpleClientDto);
    }


    @DeleteMapping("")
    public boolean deleteClient(@RequestParam Long id) {

        return clientService.deleteClient(id);

    }

}



