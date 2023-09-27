package com.example.placeapi.domain;

import com.example.placeapi.dtos.UpdatePlaceDTO;
import com.example.placeapi.dtos.CreatePlaceDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "place")
@Table(name = "places")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Place {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;
    private String state;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean status;

    public Place(CreatePlaceDTO data) {
        this.name = data.name();
        this.city = data.city();
        this.state = data.state();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = null;
        this.status = true;
    }

    public void updatePlace(UpdatePlaceDTO data) {
        if (data.name() != null) {
            this.name = data.name();
        }
        if (data.city() != null) {
            this.city = data.city();
        }
        if (data.state() != null) {
            this.state = data.state();
        }
        this.updatedAt = LocalDateTime.now();
    }

    public void disblePlace() {
        this.status = false;
    }
}
