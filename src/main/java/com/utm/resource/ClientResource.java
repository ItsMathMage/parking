package com.utm.resource;

import com.utm.dto.ClientDTO;
import com.utm.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientResource {
    @Autowired
    private ClientService clientService;

    @GetMapping("/clients/{id}")
    public ClientDTO getClientById(final @PathVariable Long id) {
        return clientService.getClientById(4L);
    }

    @GetMapping("/clients")
    public List<ClientDTO> getClientById() {
        return clientService.getAllClients();
    }

    @PostMapping("/clients")
    public ClientDTO createClient(final @RequestBody ClientDTO clientDTO) {
        return clientService.createClient(clientDTO);
    }

    @PutMapping("/clients")
    public ClientDTO updateClient(final @RequestBody ClientDTO clientDTO) {
        return clientService.updateClient(clientDTO);
    }

    @DeleteMapping("/clients/{id}")
    public void deleteClientById(final @PathVariable Long id) {
        clientService.deleteClientById(id);
    }
}
