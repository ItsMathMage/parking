package com.utm.service;

import com.utm.dto.ReserveDTO;

public interface CartService {
    ReserveDTO getCartByClientID(Long clientId);
    ReserveDTO addPlaceToCart(Long clientId, Long placeId);
    ReserveDTO removePlaceToCart(long clientId, Long pacityId);
}
