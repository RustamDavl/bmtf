package ru.rstdv.bmtf.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdateRestaurantDto;
import ru.rstdv.bmtf.dto.read.ReadRestaurantDto;
import ru.rstdv.bmtf.service.RestaurantService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/restaurants")
public class RestaurantController {

    private final RestaurantService<ReadRestaurantDto, CreateUpdateRestaurantDto> restaurantService;

    @PostMapping
    public ResponseEntity<ReadRestaurantDto> create(@RequestBody
                                                    CreateUpdateRestaurantDto createUpdateRestaurantDto) {

        var readRestaurantService = restaurantService.create(createUpdateRestaurantDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(readRestaurantService);


    }
}
