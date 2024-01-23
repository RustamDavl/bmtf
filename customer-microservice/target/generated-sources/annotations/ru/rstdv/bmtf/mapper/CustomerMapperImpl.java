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
    date = "2024-01-23T21:19:16+0300",
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
        String phone = null;
        String id = null;
        String firstName = null;
        String email = null;

        readAddressDtoList = addressListToReadAddressDtoList( customer.getAddresses() );
        phone = modifyPhone( customer.getPhone() );
        if ( customer.getId() != null ) {
            id = String.valueOf( customer.getId() );
        }
        firstName = customer.getFirstName();
        email = customer.getEmail();

        ReadCustomerDto readCustomerDto = new ReadCustomerDto( id, firstName, phone, email, readAddressDtoList );

        return readCustomerDto;
    }

    @Override
    public Customer toCustomer(CreateUpdateCustomerDto createUpdateCustomerDto) {
        if ( createUpdateCustomerDto == null ) {
            return null;
        }

        Customer.CustomerBuilder customer = Customer.builder();

        customer.phone( modifyPhone( createUpdateCustomerDto.phone() ) );
        customer.firstName( createUpdateCustomerDto.firstName() );
        customer.email( createUpdateCustomerDto.email() );
        customer.password( createUpdateCustomerDto.password() );

        return customer.build();
    }

    @Override
    public Customer updateCustomerFromDto(Customer customer, CreateUpdateCustomerDto createUpdateCustomerDto) {
        if ( createUpdateCustomerDto == null ) {
            return customer;
        }

        if ( createUpdateCustomerDto.firstName() != null ) {
            customer.setFirstName( createUpdateCustomerDto.firstName() );
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

        String id = null;
        String city = null;
        String street = null;
        String streetNumber = null;
        String doorwayNumber = null;
        String floorNumber = null;
        String flatNumber = null;

        if ( address.getId() != null ) {
            id = String.valueOf( address.getId() );
        }
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

        ReadAddressDto readAddressDto = new ReadAddressDto( id, city, street, streetNumber, doorwayNumber, floorNumber, flatNumber );

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
