package com.example.placeapi.dtos;

import com.example.placeapi.domain.Place;

public record ListPlacesDTO(String name, String city, String state) {

    public ListPlacesDTO(Place place) {
        this(place.getName(), place.getCity(), place.getState());
    }
}
