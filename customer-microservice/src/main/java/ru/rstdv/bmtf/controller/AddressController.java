package ru.rstdv.bmtf.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdateAddressDto;
import ru.rstdv.bmtf.dto.read.ReadAddressDto;
import ru.rstdv.bmtf.service.AddressService;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@RequiredArgsConstructor
@RestController
@RequestMapping(("/api/v1/customers/{customerId}/addresses"))
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/{id}")
    public ResponseEntity<ReadAddressDto> findById(@PathVariable("customerId") Long customerId,
                                                   @PathVariable("id") Long id) {
        var readAddressDto = addressService.findById(id);
        return ResponseEntity.status(OK)
                .contentType(APPLICATION_JSON)
                .body(readAddressDto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ReadAddressDto> patch(@PathVariable("customerId") Long customerId,
                                                @PathVariable("id") Long id,
                                                @RequestBody CreateUpdateAddressDto createUpdateAddressDto) {

        var updatedAddress = addressService.update(customerId, id, createUpdateAddressDto);

        return ResponseEntity.status(OK)
                .contentType(APPLICATION_JSON)
                .body(updatedAddress);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("customerId") Long customerId,
                                          @PathVariable("id") Long id) {

        var result = addressService.delete(id);

        return ResponseEntity.status(OK)
                .contentType(APPLICATION_JSON)
                .body(result);
    }

    @PostMapping
    public ResponseEntity<ReadAddressDto> create(@PathVariable("customerId") Long customerId,
                                                 @RequestBody CreateUpdateAddressDto createUpdateAddressDto) {

        var readAddressDto = addressService.create(customerId, createUpdateAddressDto);

        return ResponseEntity.status(CREATED)
                .contentType(APPLICATION_JSON)
                .body(readAddressDto);
    }
}
