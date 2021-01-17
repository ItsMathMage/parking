package com.utm.mapper;

import com.utm.dto.ClientDTO;
import com.utm.entity.Client;
import com.utm.entity.Reserve;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientToClientDTOMapper {
    public Client toEntity(final ClientDTO clientDTO, final List<Reserve> reserves) {
        final Client client = new Client();

        client.setId(clientDTO.getId());
        client.setFirstName(clientDTO.getFirstName());
        client.setLastName(clientDTO.getLastName());
        client.setAge(clientDTO.getAge());
        client.setReserves(reserves);

        return client;
    }

    public ClientDTO toDTO(final Client client) {
        final ClientDTO clientDTO = new ClientDTO();

        clientDTO.setId(client.getId());
        clientDTO.setFirstName(client.getFirstName());
        clientDTO.setLastName(client.getLastName());
        clientDTO.setAge(client.getAge());

        return clientDTO;
    }
}
