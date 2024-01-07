package ru.rstdv.bmtf.integration.service;


import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdateCustomerDto;
import ru.rstdv.bmtf.dto.read.ReadAddressDto;
import ru.rstdv.bmtf.dto.read.ReadCustomerDto;
import ru.rstdv.bmtf.exception.CustomerNotFoundException;
import ru.rstdv.bmtf.integration.IntegrationTestBase;
import ru.rstdv.bmtf.service.CustomerService;

import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor
class CustomerServiceIT extends IntegrationTestBase {

    private final CustomerService customerService;

    @Test
    void findById() {
        ReadCustomerDto readCustomerDto = customerService.findById(1L);
        var readAddressDto = new ReadAddressDto(
                "1",
                "kazan",
                "ametevo",
                "16",
                "4",
                "5",
                "384"
        );

        assertThat(readCustomerDto).isNotNull();
        assertThat(readCustomerDto.id()).isEqualTo("1");
        assertThat(readCustomerDto.email()).isEqualTo("rust@gmail.com");
        assertThat(readCustomerDto.phone()).isEqualTo("+79179209061");
        assertThat(readCustomerDto.readAddressDtoList().size()).isEqualTo(3);
        assertThat(readCustomerDto.readAddressDtoList().get(0)).isEqualTo(readAddressDto);

    }

    @Test
    void create() {
        var requestDto = new CreateUpdateCustomerDto(
                "Rust",
                "+79089887887",
                "test@gmail.com",
                "pass"
        );
        var createdCustomer = customerService.create(requestDto);
        var actualResult = customerService.findById(Long.valueOf(createdCustomer.id()));

        System.out.println(actualResult);

        assertThat(actualResult.id()).isEqualTo(createdCustomer.id());
        assertThat(actualResult.phone()).isEqualTo(createdCustomer.phone());
        assertThat(actualResult.email()).isEqualTo(createdCustomer.email());
        assertThat(actualResult.firstName()).isEqualTo(createdCustomer.firstName());


    }

    @Test
    void delete() {
        var result = customerService.delete(1L);
        assertThat(result).isTrue();
        Assertions.assertThrows(CustomerNotFoundException.class, () -> customerService.findById(1L));
    }

    @Test
    void update() {
        var requestDto = new CreateUpdateCustomerDto(
                "Rust Davlet",
                null,
                "easton12345@gmail.com",
                null
        );
        var oldResult = customerService.findById(1L);

        var updatedResult = customerService.update(1L, requestDto);
        assertThat(updatedResult.firstName()).isEqualTo(requestDto.firstName());
        assertThat(updatedResult.email()).isEqualTo(requestDto.email());
        assertThat(updatedResult.phone()).isNotNull();
        assertThat(updatedResult.phone()).isEqualTo(oldResult.phone());
    }



}
