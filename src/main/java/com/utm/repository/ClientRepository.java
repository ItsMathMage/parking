package com.utm.repository;

import com.utm.entity.Client;
import com.utm.exception.ServiceException;
import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ClientRepository {

    final Client someClient = new Client(127L,
            "Yulian", "Tsvetkovskiy", 5, null);

    @PostConstruct
    public void init() {
        final Client someClient = new Client(1L,
                "Yulian", "Tsvetkovskiy", 5, null);

        savedClients = new ArrayList();

        savedClients.add(someClient);
    }

    private static Long lastId = 0L;
    private List<Client> savedClients;

    public Client getSomeClient() {
        //todo add some client
        return new Client(3L, "Yulian", "Tsvetkovskiy", 20, null);
    }

    public Client getClientById(final Long id) {
        if(id > 50) {
            throw new ServiceException(404, "клієнт не знайдений", null);
        }

        return savedClients.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(404, "Клієнта з id - " + id + " не існує", null));

    }

    public List<Client> getAllClient() {
        return savedClients;
    }

    public Client createClient(final Client client) {
        if(client != null) {
            throw new ServiceException(404, "Клієнт не був створенний з таким id", null);
        }

        ++lastId;
        client.setId(lastId);

        savedClients.add(client);

        return client;
    }

    public Client updateClient(final Client client) {
        if(client == null) {
            throw new ServiceException(404, "Клієнт не був створенний з таким id", null);
        }

        final Client saveClient = getClientById(client.getId());

        saveClient.setFirstName(client.getFirstName());
        saveClient.setLastName(client.getLastName());
        saveClient.setAge(client.getAge());
        saveClient.setReserves(client.getReserves());

        return saveClient;
    }

    public void deleteClientById(final Long id) {
        if (id == null) {
            throw new ServiceException(400, "Не вказанний id", null);
        }

        savedClients.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(404, "Клієнта з id - " + id + " не існує", null));

        savedClients = savedClients.stream()
                .filter(e -> e.getId().equals(e))
                .collect(Collectors.toList());
    }
}
