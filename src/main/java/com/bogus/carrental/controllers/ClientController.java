package com.bogus.carrental.controllers;

import com.bogus.carrental.model.Client;
import com.bogus.carrental.model.dtos.ClientDto;
import com.bogus.carrental.model.dtos.ClientFormDto;
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
    public List<ClientDto> showAllClients() {

        return clientService.showAllClients();

    }


    @GetMapping("/details")
    public ClientDto getClientById(@RequestParam(name = "id") Long id) {

        return clientService.showClientById(id);

    }


    @PostMapping("")
    @ResponseBody
    public ClientFormDto createClient(@RequestBody ClientFormDto clientFormDto) {

        return clientService.createClient(clientFormDto);

    }


    @PatchMapping("")
    @ResponseBody
    public ClientDto updateClient(@RequestBody ClientDto clientDto,
                            @RequestParam(name = "id") Long id) {

        return clientService.updateClient(id, clientDto);

    }

    @DeleteMapping("")
    public void deleteClient(@RequestParam(name = "id") Long id) {

        clientService.deleteClientById(id);

    }


}
