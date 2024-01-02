package ru.rstdv.bmtf.unit.mapper;


import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdateCustomerDto;
import ru.rstdv.bmtf.dto.read.ReadAddressDto;
import ru.rstdv.bmtf.dto.read.ReadCustomerDto;
import ru.rstdv.bmtf.entity.Address;
import ru.rstdv.bmtf.entity.Customer;
import ru.rstdv.bmtf.mapper.CustomerMapper;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RequiredArgsConstructor
public class CustomerMapperTest {

    private CustomerMapper customerMapper;


    @BeforeEach
    void setUp() {
        customerMapper = customerMapper.INSTANCE;
    }

    @Test
    void toReadCustomerDto() {
        var addresses = List.of(
                Address.builder()
                        .city("Kazan")
                        .street("Ametevo")
                        .streetNumber((short) 16)
                        .doorwayNumber((short) 4)
                        .floorNumber((short) 5)
                        .flatNumber((short) 384)
                        .build(),

                Address.builder()
                        .city("Leninogorsk")
                        .street("Lenina")
                        .streetNumber((short) 17)
                        .doorwayNumber((short) 4)
                        .floorNumber((short) 5)
                        .flatNumber((short) 384)
                        .build()
        );

        var givenCustomer = Customer.builder()
                .id(1L)
                .email("test@gmail.com")
                .phone("88888888888")
                .password("pass")
                .addresses(addresses)
                .build();

        var expectedResult = new ReadCustomerDto(
                "1",
                "88888888888",
                "test@gmail.com",
                List.of(
                        new ReadAddressDto(
                                "Kazan",
                                "Ametevo",
                                "16",
                                "4",
                                "5",
                                "384"),
                        new ReadAddressDto(
                                "Leninogorsk",
                                "Lenina",
                                "17",
                                "4",
                                "5",
                                "384")
                )
        );

        var actualResult = customerMapper.toReadCustomerDto(givenCustomer);

        assertThat(actualResult).isEqualTo(expectedResult);
        assertThat(actualResult.email()).isEqualTo(expectedResult.email());
        assertThat(actualResult.phone()).isEqualTo(expectedResult.phone());
        assertThat(actualResult.readAddressDtoList().size()).isEqualTo(expectedResult.readAddressDtoList().size());
        assertThat(actualResult.readAddressDtoList().get(0)).isEqualTo(expectedResult.readAddressDtoList().get(0));
    }

    @Test
    void toCustomer() {

    }

    @Test
    void updateCustomerFromDto() {
        var addresses = List.of(
                Address.builder()
                        .city("Kazan")
                        .street("Ametevo")
                        .streetNumber((short) 16)
                        .doorwayNumber((short) 4)
                        .floorNumber((short) 5)
                        .flatNumber((short) 384)
                        .build(),

                Address.builder()
                        .city("Leninogorsk")
                        .street("Lenina")
                        .streetNumber((short) 17)
                        .doorwayNumber((short) 4)
                        .floorNumber((short) 5)
                        .flatNumber((short) 384)
                        .build()
        );

        var actualCustomer = Customer.builder()
                .id(1L)
                .email("test@gmail.com")
                .phone("88888888888")
                .password("pass")
                .addresses(addresses)
                .build();

        var customerFromRequest = new CreateUpdateCustomerDto(
                "88888888899",
                "updated@gmail.com",
                "qwerty"
        );

        var updatedCustomer = customerMapper.updateCustomerFromDto(actualCustomer, customerFromRequest);

        assertThat(updatedCustomer.getPhone()).isEqualTo(customerFromRequest.phone());
        assertThat(updatedCustomer.getEmail()).isEqualTo(customerFromRequest.email());
        assertThat(updatedCustomer.getPassword()).isEqualTo(customerFromRequest.password());
        assertThat(updatedCustomer.getId()).isEqualTo(actualCustomer.getId());
        assertThat(updatedCustomer.getAddresses().size()).isEqualTo(actualCustomer.getAddresses().size());
        assertThat(updatedCustomer.getAddresses().get(0)).isEqualTo(actualCustomer.getAddresses().get(0));
    }
}
