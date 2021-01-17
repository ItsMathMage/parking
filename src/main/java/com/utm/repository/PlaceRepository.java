package com.utm.repository;

import com.utm.entity.Place;
import com.utm.exception.ServiceException;
import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PlaceRepository {
    @PostConstruct
    public void init(){
        savedPlaces = new ArrayList<>();
    }

    private static Long lastId = 1L;
    private List<Place> savedPlaces;

    public Place getSomePlace() {
        return new Place(1L, 1, 100.50, true);
    }

    public Place getPlaceById(final Long id){
        return savedPlaces.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "Місце не знайдене", null));
    }

    public List<Place> getAllPlaces(){
        return savedPlaces;
    }

    public Place createPlace(final Place place){
        if(place.getId() != null){
            throw new ServiceException(400, "Не знайдено книжки з таким id ", null);
        }

        ++lastId;
        place.setId(lastId);

        savedPlaces.add(place);

        return place;
    }

    public Place updatePlace(final Place place){
        if(place.getId() == null){
            throw new ServiceException(400, "Не знайдено клієнта з таким id", null);
        }

        final Place savedPlace = getPlaceById(place.getId());

        savedPlace.setNumber(place.getNumber());
        savedPlace.setPrice(place.getPrice());
        savedPlace.setEmpty(place.getEmpty());

        return savedPlace;
    }

    public void deletePlaceById(final Long id) {
        if (id == null) {
            throw new ServiceException(400, "Не знайдено клієнта з таким id", null);
        }

        savedPlaces.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "Не знайдено клієнта з таким id", null));

        savedPlaces = savedPlaces.stream()
                .filter(e -> !e.getId().equals(id))
                .collect(Collectors.toList());
    }
}
