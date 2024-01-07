package ru.rstdv.bmtf.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdateCustomerDto;
import ru.rstdv.bmtf.dto.read.ReadCustomerDto;
import ru.rstdv.bmtf.service.CustomerService;
import ru.rstdv.bmtf.validation.group.OnCreateAction;
import ru.rstdv.bmtf.validation.group.OnUpdateAction;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<ReadCustomerDto> create(@RequestBody
                                                  @Validated({OnCreateAction.class})
                                                  CreateUpdateCustomerDto createUpdateCustomerDto) {

        var readCustomerDto = customerService.create(createUpdateCustomerDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(readCustomerDto);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ReadCustomerDto> findById(@PathVariable("id") Long id) {

        var readCustomerDto = customerService.findById(id);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(readCustomerDto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ReadCustomerDto> patch(@PathVariable("id") Long id,
                                                 @RequestBody
                                                 @Validated({OnUpdateAction.class})
                                                 CreateUpdateCustomerDto createUpdateCustomerDto) {

        var readCustomerDto = customerService.update(id, createUpdateCustomerDto);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(readCustomerDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {

        var result = customerService.delete(id);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(result);
    }


}
