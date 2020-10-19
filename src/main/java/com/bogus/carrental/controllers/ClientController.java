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

        return clientService.findAllActiveClients();

    }


    @GetMapping("/{id}")
    public ClientDto getClientById(@PathVariable Long id) {

        return clientService.showClientById(id);

    }
    @GetMapping("/username/{username}")
    public ClientDto getClientByUsername(@PathVariable String username) {

        return clientService.showClientByUsername(username);

    }

    @PostMapping("")
    @ResponseBody
    public ClientFormDto createClient(@RequestBody ClientFormDto clientFormDto) {

        return clientService.createClient(clientFormDto);

    }


    @PutMapping("/{id}")
    @ResponseBody
    public ClientDto updateClient(@RequestBody ClientFormDto clientFormDto,
                                  @PathVariable Long id) {

        return clientService.updateClient(id, clientFormDto);

    }

    @DeleteMapping("/{id}")
    public void deactivateClient(@PathVariable Long id) {

        clientService.deactivateClientAccountById(id);

    }


}
