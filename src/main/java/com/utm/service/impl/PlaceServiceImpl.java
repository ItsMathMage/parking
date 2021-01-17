package com.utm.service.impl;

import com.utm.dto.PlaceDTO;
import com.utm.mapper.PlaceToPlaceDTOMapper;
import com.utm.repository.PlaceRepository;
import com.utm.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
class PlaceServiceImpl implements PlaceService {
    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private PlaceToPlaceDTOMapper placeToPlaceDTOMapper;

    @Override
    public PlaceDTO getPlaceById(final Long id) {
        return placeToPlaceDTOMapper.toDTO(placeRepository.getSomePlace());
    }

    @Override
    public List<PlaceDTO> getAllPlaces() {
        return Collections.singletonList(placeToPlaceDTOMapper.toDTO(placeRepository.getSomePlace()));
    }

    @Override
    public PlaceDTO createPlace(PlaceDTO placeDTO) {
        return null;
    }

    @Override
    public PlaceDTO updatePlace(PlaceDTO placeDTO) {
        return null;
    }

    @Override
    public void deletePlaceById(Long id) {

    }
}
