package com.example.placeapi.dtos;

import com.example.placeapi.domain.Place;

import java.time.LocalDateTime;

public record PlaceDetailsDTO(
        Long id,
        String name,
        String city,
        String state,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        Boolean status) {

    public PlaceDetailsDTO(Place place) {
        this(place.getId(), place.getName(), place.getCity(), place.getState(),
                place.getCreatedAt(), place.getUpdatedAt(), place.getStatus());
    }
}

