package com.utm.mapper;

import com.utm.dto.PlaceDTO;
import com.utm.entity.Place;
import org.springframework.stereotype.Component;

@Component
public class PlaceToPlaceDTOMapper {
    public Place toEntity(final PlaceDTO placeDTO) {
        final Place place = new Place();

        place.setId(placeDTO.getId());
        place.setNumber(placeDTO.getNumber());
        place.setPrice(placeDTO.getPrice());
        place.setEmpty(placeDTO.getEmpty());

        return place;
    }

    public PlaceDTO toDTO(final Place place) {
        final PlaceDTO placeDTO = new PlaceDTO();

        placeDTO.setId(place.getId());
        placeDTO.setNumber(place.getNumber());
        placeDTO.setPrice(place.getPrice());
        placeDTO.setEmpty(place.getEmpty());

        return placeDTO;
    }
}
