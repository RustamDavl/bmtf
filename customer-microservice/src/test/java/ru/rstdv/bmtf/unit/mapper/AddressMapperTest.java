package ru.rstdv.bmtf.unit.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdateAddressDto;
import ru.rstdv.bmtf.dto.read.ReadAddressDto;
import ru.rstdv.bmtf.entity.Address;
import ru.rstdv.bmtf.mapper.AddressMapper;

import static org.assertj.core.api.Assertions.assertThat;

class AddressMapperTest {

    private AddressMapper addressMapper;

    //todo mock address mapper or something else.
    //the project is not compiled because of this module does not have annotation processor path for lombok...


    @BeforeEach
    void setUp() {
        addressMapper = AddressMapper.INSTANCE;
    }

    @Test
    void toReadAddressDto() {
        //given
        var givenAddress = Address.builder()
                .city("Kazan")
                .street("Ametevo")
                .streetNumber((short) 16)
                .doorwayNumber((short) 4)
                .floorNumber((short) 5)
                .flatNumber((short) 384)
                .build();

        //when
        var actualResult = addressMapper.toReadAddressDto(givenAddress);


        //then
        var expectedResult = new ReadAddressDto(
                "Kazan",
                "Ametevo",
                "16",
                "4",
                "5",
                "384");

        assertThat(actualResult).isEqualTo(expectedResult);
        assertThat(actualResult.city()).isEqualTo(expectedResult.city());
        assertThat(actualResult.street()).isEqualTo(expectedResult.street());
        assertThat(actualResult.streetNumber()).isEqualTo(expectedResult.streetNumber());
        assertThat(actualResult.doorwayNumber()).isEqualTo(expectedResult.doorwayNumber());
        assertThat(actualResult.floorNumber()).isEqualTo(expectedResult.floorNumber());
        assertThat(actualResult.flatNumber()).isEqualTo(expectedResult.flatNumber());


    }

    @Test
    void toAddress() {
        var givenCreateUpdateAddressDto = new CreateUpdateAddressDto(
                "1",
                "Kazan",
                "Ametevo",
                "16",
                "4",
                "5",
                "384"
        );

        var expectedResult = Address.builder()
                .city("Kazan")
                .street("Ametevo")
                .streetNumber((short) 16)
                .doorwayNumber((short) 4)
                .floorNumber((short) 5)
                .flatNumber((short) 384)
                .build();

        var actualResult = addressMapper.toAddress(givenCreateUpdateAddressDto);

        assertThat(actualResult).isEqualTo(expectedResult);
        assertThat(actualResult.getCity()).isEqualTo(expectedResult.getCity());
        assertThat(actualResult.getStreet()).isEqualTo(expectedResult.getStreet());
        assertThat(actualResult.getStreetNumber()).isEqualTo(expectedResult.getStreetNumber());
        assertThat(actualResult.getDoorwayNumber()).isEqualTo(expectedResult.getDoorwayNumber());
        assertThat(actualResult.getFloorNumber()).isEqualTo(expectedResult.getFloorNumber());
        assertThat(actualResult.getFlatNumber()).isEqualTo(expectedResult.getFlatNumber());

    }
}