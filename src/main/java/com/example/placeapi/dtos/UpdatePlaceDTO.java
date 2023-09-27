package com.example.placeapi.dtos;

import jakarta.validation.constraints.NotNull;

public record UpdatePlaceDTO(
        @NotNull
        Long id,
        String name,
        String city,
        String state) {
}
