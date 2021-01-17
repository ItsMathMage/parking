package com.utm.service;

import com.utm.dto.PlaceDTO;

import java.util.List;

public interface PlaceService {
    PlaceDTO getPlaceById(Long number);
    List<PlaceDTO> getAllPlaces();
    PlaceDTO createPlace(PlaceDTO placeDTO);
    PlaceDTO updatePlace(PlaceDTO placeDTO);
    void deletePlaceById(Long id);
}
