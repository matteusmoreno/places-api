package com.example.placeapi.cotroller;

import com.example.placeapi.domain.Place;
import com.example.placeapi.dtos.CreatePlaceDTO;
import com.example.placeapi.dtos.ListPlacesDTO;
import com.example.placeapi.dtos.PlaceDetailsDTO;
import com.example.placeapi.dtos.UpdatePlaceDTO;
import com.example.placeapi.repository.PlaceRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/place")
public class PlaceController {

    private final PlaceRepository repository;

    public PlaceController(PlaceRepository repository) {
        this.repository = repository;
    }


    @PostMapping
    @Transactional
    public ResponseEntity createPlace (@RequestBody @Valid CreatePlaceDTO data, UriComponentsBuilder uriBuilder) {
        var place = new Place(data);
        repository.save(place);

        var uri = uriBuilder.path("/place/{id}").buildAndExpand(place.getId()).toUri();

        return ResponseEntity.created(uri).body(new PlaceDetailsDTO(place));
    }

    @GetMapping
    public ResponseEntity<Page<ListPlacesDTO>> listPlaces(@PageableDefault(size = 10, sort = {"name"}) Pageable pagination) {
        var page = repository.findAllByStatusTrue(pagination).map(ListPlacesDTO::new);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity placeDetails(@PathVariable Long id) {
        var place = repository.getReferenceById(id);

        return ResponseEntity.ok().body(new PlaceDetailsDTO(place));
    }

    @PutMapping
    @Transactional
    public ResponseEntity updatePlace(@RequestBody @Valid UpdatePlaceDTO data) {
        var place = repository.getReferenceById(data.id());
        place.updatePlace(data);

        return ResponseEntity.ok().body(new PlaceDetailsDTO(place));

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity disablePlace(@PathVariable Long id) {
        var place = repository.getReferenceById(id);
        place.disblePlace();

        return ResponseEntity.noContent().build();
    }


}
