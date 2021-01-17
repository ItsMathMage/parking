package com.utm.service.impl;

import com.utm.dto.ReserveDTO;
import com.utm.entity.Place;
import com.utm.entity.Reserve;
import com.utm.mapper.ReserveToReserveDTOMapper;
import com.utm.repository.ClientRepository;
import com.utm.repository.PlaceRepository;
import com.utm.repository.ReserveRepository;
import com.utm.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private ReserveRepository reserveRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private ReserveToReserveDTOMapper reserveDTOMapper;

    @Override
    public ReserveDTO getCartByClientID(Long clientId) {
        return null;
    }

    @Override
    public ReserveDTO addPlaceToCart(Long clientId, Long placeId) {
        final List<Reserve> reserves = reserveRepository.getReservesByClientId(clientId);

        Reserve reserve = reserves.stream()
                .filter(e -> !e.getPay())
                .findFirst()
                .orElse(null);
        
        if (reserve == null) {
            reserve = new Reserve();
            reserve.setReserveDate(LocalDate.now());
            reserve.setClient(clientRepository.getClientById(clientId));

            reserveRepository.createReserve(reserve);
        }

        final Place place= placeRepository.getPlaceById(clientId);

        if(reserve.getReserveDetails().containsKey(place)) {
            int value = reserve.getReserveDetails().get(place);
            reserve.getReserveDetails().put(place, ++value);
        } else {
            reserve.getReserveDetails().put(place, 1);
        }

        reserveRepository.createReserve(reserve);

        return reserveDTOMapper.toDTO(reserve);
    }

    @Override
    public ReserveDTO removePlaceToCart(final long clientId, final Long pacityId) {
        return null;
    }
}
