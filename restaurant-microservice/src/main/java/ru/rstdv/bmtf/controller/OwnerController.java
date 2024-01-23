package ru.rstdv.bmtf.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdateOwnerDto;
import ru.rstdv.bmtf.dto.read.ReadOwnerDto;
import ru.rstdv.bmtf.service.OwnerService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/owners")
public class OwnerController {

    private final OwnerService<ReadOwnerDto, CreateUpdateOwnerDto> ownerServiceImpl;

    @PostMapping
    public ResponseEntity<ReadOwnerDto> create(@RequestBody CreateUpdateOwnerDto object) {
        var readOwnerDto = ownerServiceImpl.create(object);
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(readOwnerDto);

    }
}
