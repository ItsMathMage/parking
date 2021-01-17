package com.utm.service;

import com.utm.dto.ClientDTO;

import java.util.List;

public interface ClientService {
    ClientDTO getSomeClient();

    ClientDTO getClientById(Long id);
    List<ClientDTO> getAllClients();
    ClientDTO createClient(ClientDTO clientDTO);
    ClientDTO updateClient(ClientDTO clientDTO);
    void deleteClientById(Long id);
}
