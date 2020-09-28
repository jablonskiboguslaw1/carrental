package com.bogus.carrental.controllers;

import com.bogus.carrental.model.dtos.ClientDto;
import com.bogus.carrental.model.dtos.ClientFormDto;
import com.bogus.carrental.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {


    private final ClientService clientService;

    @GetMapping("")
    public List<ClientDto> showAllClients() {

        return clientService.showAllClients();

    }


    @GetMapping("/{id}")
    public ClientDto getClientById(@PathVariable Long id) {

        return clientService.showClientById(id);

    }


    @PostMapping("")
    @ResponseBody
    public ClientFormDto createClient(@RequestBody ClientFormDto clientFormDto) {

        return clientService.createClient(clientFormDto);

    }


    @PatchMapping("/{id}")
    @ResponseBody
    public ClientDto updateClient(@RequestBody ClientDto clientDto,
                                  @PathVariable Long id) {

        return clientService.updateClient(id, clientDto);

    }

    @DeleteMapping("")
    public void deleteClient(@RequestParam(name = "id") Long id) {

        clientService.deleteClientById(id);

    }


}
