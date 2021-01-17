package com.utm.resource;

import com.utm.dto.ReserveDTO;
import com.utm.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartResourse {
    @Autowired
    public CartService cartService;

    @GetMapping("/cart/{id}")
    public ReserveDTO getClientById(final @PathVariable Long clientID) {
        return cartService.getCartByClientID(clientID);
    }

    @PostMapping("/cart/{id}/{placeId}")
    public ReserveDTO getClientById(final @PathVariable Long clientID,
                                    final @PathVariable Long placeId) {
        return cartService.addPlaceToCart(clientID, placeId);
    }

    @DeleteMapping("/delete-to-cart/{id}/{placeId}")
    public ReserveDTO removePlaceToCart(final @PathVariable Long clientID,
                                    final @PathVariable Long placeId) {
        return cartService.removePlaceToCart(clientID, placeId);
    }
}
