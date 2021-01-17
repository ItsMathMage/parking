package com.utm.service.impl;

import com.utm.dto.ClientDTO;
import com.utm.entity.Client;
import com.utm.exception.ServiceException;
import com.utm.mapper.ClientToClientDTOMapper;
import com.utm.repository.ClientRepository;
import com.utm.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientToClientDTOMapper clientDTOMapper;

    public ClientDTO getSomeClient() {
        final Client someClient = clientRepository.getSomeClient();
        return clientDTOMapper.toDTO(someClient);
    }

    @Override
    public ClientDTO getClientById(final Long id) {
        return clientDTOMapper.toDTO(clientRepository.getClientById(id));
    }

    @Override
    public List<ClientDTO> getAllClients() {
        return clientRepository.getAllClient().stream()
                .map(e -> clientDTOMapper.toDTO(e))
                .collect(Collectors.toList());
    }

    @Override
    public ClientDTO createClient(final ClientDTO clientDTO) {
        if (clientDTO.getId() != null) {
            throw new ServiceException(404, "Клієнт не був створенний з таким id", null);
        }
        
        return clientDTOMapper.toDTO(clientRepository.createClient(clientDTOMapper.toEntity(clientDTO, null)));
    }

    @Override
    public ClientDTO updateClient(ClientDTO clientDTO) {
        if (clientDTO.getId() == null) {
            throw new ServiceException(404, "Клієнт не був створенний з таким id", null);
        }

        return clientDTOMapper.toDTO(clientRepository.createClient(clientDTOMapper.toEntity(clientDTO, null)));
    }

    @Override
    public void deleteClientById(Long id) {
        clientRepository.deleteClientById(id);
    }
}
