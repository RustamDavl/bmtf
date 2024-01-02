package ru.rstdv.bmtf.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdateAddressDto;
import ru.rstdv.bmtf.dto.read.ReadAddressDto;
import ru.rstdv.bmtf.entity.Address;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-27T22:59:05+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class AddressMapperImpl implements AddressMapper {

    @Override
    public ReadAddressDto toReadAddressDto(Address address) {
        if ( address == null ) {
            return null;
        }

        String city = null;
        String street = null;
        String streetNumber = null;
        String doorwayNumber = null;
        String floorNumber = null;
        String flatNumber = null;

        city = address.getCity();
        street = address.getStreet();
        if ( address.getStreetNumber() != null ) {
            streetNumber = String.valueOf( address.getStreetNumber() );
        }
        if ( address.getDoorwayNumber() != null ) {
            doorwayNumber = String.valueOf( address.getDoorwayNumber() );
        }
        if ( address.getFloorNumber() != null ) {
            floorNumber = String.valueOf( address.getFloorNumber() );
        }
        if ( address.getFlatNumber() != null ) {
            flatNumber = String.valueOf( address.getFlatNumber() );
        }

        ReadAddressDto readAddressDto = new ReadAddressDto( city, street, streetNumber, doorwayNumber, floorNumber, flatNumber );

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
        if ( createUpdateAddressDto.streetNumber() != null ) {
            address.streetNumber( Short.parseShort( createUpdateAddressDto.streetNumber() ) );
        }
        if ( createUpdateAddressDto.doorwayNumber() != null ) {
            address.doorwayNumber( Short.parseShort( createUpdateAddressDto.doorwayNumber() ) );
        }
        if ( createUpdateAddressDto.floorNumber() != null ) {
            address.floorNumber( Short.parseShort( createUpdateAddressDto.floorNumber() ) );
        }
        if ( createUpdateAddressDto.flatNumber() != null ) {
            address.flatNumber( Short.parseShort( createUpdateAddressDto.flatNumber() ) );
        }

        return address.build();
    }
}
