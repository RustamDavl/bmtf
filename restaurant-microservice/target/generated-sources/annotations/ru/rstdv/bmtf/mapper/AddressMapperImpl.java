package ru.rstdv.bmtf.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdateAddressDto;
import ru.rstdv.bmtf.dto.read.ReadAddressDto;
import ru.rstdv.bmtf.entity.Address;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-14T22:07:32+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class AddressMapperImpl implements AddressMapper {

    @Override
    public ReadAddressDto toReadAddressDto(Address address) {
        if ( address == null ) {
            return null;
        }

        String id = null;
        String city = null;
        String street = null;
        String houseNumber = null;

        if ( address.getId() != null ) {
            id = String.valueOf( address.getId() );
        }
        city = address.getCity();
        street = address.getStreet();
        houseNumber = address.getHouseNumber();

        ReadAddressDto readAddressDto = new ReadAddressDto( id, city, street, houseNumber );

        return readAddressDto;
    }

    @Override
    public Address toAddress(CreateUpdateAddressDto createUpdateAddressDto) {
        if ( createUpdateAddressDto == null ) {
            return null;
        }

        Address.AddressBuilder address = Address.builder();

        address.city( createUpdateAddressDto.city() );
        address.street( createUpdateAddressDto.street() );
        address.houseNumber( createUpdateAddressDto.houseNumber() );

        return address.build();
    }

    @Override
    public Address updateAddressFromDto(Address address, CreateUpdateAddressDto createUpdateAddressDto) {
        if ( createUpdateAddressDto == null ) {
            return address;
        }

        if ( createUpdateAddressDto.city() != null ) {
            address.setCity( createUpdateAddressDto.city() );
        }
        if ( createUpdateAddressDto.street() != null ) {
            address.setStreet( createUpdateAddressDto.street() );
        }
        if ( createUpdateAddressDto.houseNumber() != null ) {
            address.setHouseNumber( createUpdateAddressDto.houseNumber() );
        }

        return address;
    }
}
