package com.utm.repository;

import com.utm.entity.Client;
import com.utm.entity.Place;
import com.utm.entity.Reserve;
import com.utm.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ReserveRepository {
    @Autowired
    ClientRepository clientRepository;

    @PostConstruct
    public void init() {
        savedReserves = new ArrayList();
    }

    private static Long lastId = 1L;
    private List<Reserve> savedReserves;

    public List<Reserve> getReservesByClientId(final Long id) {
        final Client client = clientRepository.getClientById(id);

        client.getReserves();

        return client.getReserves();
    }

    public Reserve getReservesById(final Long id) {
        return savedReserves.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "Клієнта з таким id не знайдено", null));
    }

    public List<Reserve> getAllReserves() {
        return savedReserves;
    }

    public Place getSomePlace() {
        return new Place(1L, 1, 100.50, true);
    }

    public Reserve createReserve(final Reserve reserve) {
        if (reserve.getId() != null) {
            throw new ServiceException(400, "Бронювання з таким id не знайдено", null);
        }

        ++lastId;
        reserve.setId(lastId);

        savedReserves.add(reserve);

        reserve.getClient().getReserves().add(reserve);

        return reserve;
    }

    public Reserve updateOrder(final Reserve reserve){
        if(reserve.getId() == null){
            throw new ServiceException(400, "Бронювання з таким id не знайдено", null);
        }

        final Reserve savedReserve = getReservesById(reserve.getId());

        savedReserve.setId(reserve.getId());
        savedReserve.setReserveDate(reserve.getReserveDate());
        savedReserve.setReserveDetails(reserve.getReserveDetails());

        return savedReserve;
    }

    public void deleteOrderById(final Long id){
        if(id == null){
            throw new ServiceException(400, "Бронювання з таким id не знайдено", null);
        }

        savedReserves.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "Бронювання з таким id не знайдено", null));

        savedReserves = savedReserves.stream()
                .filter(e -> !e.getId().equals(id))
                .collect(Collectors.toList());

    }
}
