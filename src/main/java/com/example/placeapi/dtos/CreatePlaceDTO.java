package com.example.placeapi.dtos;

import jakarta.validation.constraints.NotBlank;

public record CreatePlaceDTO(
        @NotBlank
        String name,
        @NotBlank
        String city,
        @NotBlank
        String state) {
}
