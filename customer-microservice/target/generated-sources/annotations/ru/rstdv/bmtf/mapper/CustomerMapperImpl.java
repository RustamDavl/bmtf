package ru.rstdv.bmtf.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdateCustomerDto;
import ru.rstdv.bmtf.dto.read.ReadAddressDto;
import ru.rstdv.bmtf.dto.read.ReadCustomerDto;
import ru.rstdv.bmtf.entity.Address;
import ru.rstdv.bmtf.entity.Customer;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-01T19:27:55+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public ReadCustomerDto toReadCustomerDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        List<ReadAddressDto> readAddressDtoList = null;
        String id = null;
        String phone = null;
        String email = null;

        readAddressDtoList = addressListToReadAddressDtoList( customer.getAddresses() );
        if ( customer.getId() != null ) {
            id = String.valueOf( customer.getId() );
        }
        phone = customer.getPhone();
        email = customer.getEmail();

        ReadCustomerDto readCustomerDto = new ReadCustomerDto( id, phone, email, readAddressDtoList );

        return readCustomerDto;
    }

    @Override
    public Customer toCustomer(CreateUpdateCustomerDto createUpdateCustomerDto) {
        if ( createUpdateCustomerDto == null ) {
            return null;
        }

        Customer.CustomerBuilder customer = Customer.builder();

        customer.phone( createUpdateCustomerDto.phone() );
        customer.email( createUpdateCustomerDto.email() );
        customer.password( createUpdateCustomerDto.password() );

        return customer.build();
    }

    @Override
    public Customer updateCustomerFromDto(Customer customer, CreateUpdateCustomerDto createUpdateCustomerDto) {
        if ( createUpdateCustomerDto == null ) {
            return customer;
        }

        if ( createUpdateCustomerDto.phone() != null ) {
            customer.setPhone( createUpdateCustomerDto.phone() );
        }
        if ( createUpdateCustomerDto.email() != null ) {
            customer.setEmail( createUpdateCustomerDto.email() );
        }
        if ( createUpdateCustomerDto.password() != null ) {
            customer.setPassword( createUpdateCustomerDto.password() );
        }

        return customer;
    }

    protected ReadAddressDto addressToReadAddressDto(Address address) {
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

    protected List<ReadAddressDto> addressListToReadAddressDtoList(List<Address> list) {
        if ( list == null ) {
            return null;
        }

        List<ReadAddressDto> list1 = new ArrayList<ReadAddressDto>( list.size() );
        for ( Address address : list ) {
            list1.add( addressToReadAddressDto( address ) );
        }

        return list1;
    }
}