package ru.rstdv.bmtf.mapper;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdateAddressDto;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdateContactDto;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdateRestaurantDto;
import ru.rstdv.bmtf.dto.read.ReadAddressDto;
import ru.rstdv.bmtf.dto.read.ReadContactDto;
import ru.rstdv.bmtf.dto.read.ReadMenuCategoryDto;
import ru.rstdv.bmtf.dto.read.ReadOwnerDto;
import ru.rstdv.bmtf.dto.read.ReadPositionDto;
import ru.rstdv.bmtf.dto.read.ReadRestaurantDto;
import ru.rstdv.bmtf.dto.read.ReadRestaurantScheduleDto;
import ru.rstdv.bmtf.entity.Address;
import ru.rstdv.bmtf.entity.Contact;
import ru.rstdv.bmtf.entity.MenuCategory;
import ru.rstdv.bmtf.entity.Restaurant;
import ru.rstdv.bmtf.entity.RestaurantSchedule;
import ru.rstdv.bmtf.entity.embeddable.PaymentMethod;
import ru.rstdv.bmtf.entity.embeddable.RestaurantStatus;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-23T21:21:23+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class RestaurantMapperImpl implements RestaurantMapper {

    @Autowired
    private OwnerMapper ownerMapper;

    @Override
    public Restaurant toRestaurant(CreateUpdateRestaurantDto createUpdateRestaurantDto) {
        if ( createUpdateRestaurantDto == null ) {
            return null;
        }

        Restaurant.RestaurantBuilder restaurant = Restaurant.builder();

        try {
            restaurant.titlePhoto( getBytes( createUpdateRestaurantDto.titlePhoto() ) );
        }
        catch ( IOException e ) {
            throw new RuntimeException( e );
        }
        restaurant.address( createUpdateAddressDtoToAddress( createUpdateRestaurantDto.createUpdateAddressDto() ) );
        try {
            restaurant.owner( createOwner( createUpdateRestaurantDto.ownerId() ) );
        }
        catch ( IOException e ) {
            throw new RuntimeException( e );
        }
        restaurant.contact( createUpdateContactDtoToContact( createUpdateRestaurantDto.createUpdateContactDto() ) );
        restaurant.email( createUpdateRestaurantDto.email() );
        restaurant.name( createUpdateRestaurantDto.name() );
        if ( createUpdateRestaurantDto.paymentMethod() != null ) {
            restaurant.paymentMethod( Enum.valueOf( PaymentMethod.class, createUpdateRestaurantDto.paymentMethod() ) );
        }

        restaurant.status( RestaurantStatus.UNCONFIRMED );

        return restaurant.build();
    }

    @Override
    public ReadRestaurantDto toReadRestaurantDto(Restaurant restaurant) {
        if ( restaurant == null ) {
            return null;
        }

        List<ReadRestaurantScheduleDto> restaurantSchedules = null;
        ReadAddressDto readAddressDto = null;
        ReadOwnerDto readOwnerDto = null;
        List<ReadMenuCategoryDto> readMenuCategoryDtos = null;
        ReadContactDto readContactDto = null;
        String id = null;
        String email = null;
        String name = null;
        String paymentMethod = null;
        String status = null;

        restaurantSchedules = restaurantScheduleListToReadRestaurantScheduleDtoList( restaurant.getRestaurantSchedules() );
        readAddressDto = addressToReadAddressDto( restaurant.getAddress() );
        readOwnerDto = ownerMapper.toReadOwnerDto( restaurant.getOwner() );
        readMenuCategoryDtos = menuCategoryListToReadMenuCategoryDtoList( restaurant.getCategories() );
        readContactDto = contactToReadContactDto( restaurant.getContact() );
        if ( restaurant.getId() != null ) {
            id = String.valueOf( restaurant.getId() );
        }
        email = restaurant.getEmail();
        name = restaurant.getName();
        if ( restaurant.getPaymentMethod() != null ) {
            paymentMethod = restaurant.getPaymentMethod().name();
        }
        if ( restaurant.getStatus() != null ) {
            status = restaurant.getStatus().name();
        }

        ReadRestaurantDto readRestaurantDto = new ReadRestaurantDto( id, email, name, restaurantSchedules, readAddressDto, paymentMethod, readOwnerDto, readMenuCategoryDtos, readContactDto, status );

        return readRestaurantDto;
    }

    protected Address createUpdateAddressDtoToAddress(CreateUpdateAddressDto createUpdateAddressDto) {
        if ( createUpdateAddressDto == null ) {
            return null;
        }

        Address.AddressBuilder address = Address.builder();

        address.city( createUpdateAddressDto.city() );
        address.street( createUpdateAddressDto.street() );
        if ( createUpdateAddressDto.houseNumber() != null ) {
            address.houseNumber( Short.parseShort( createUpdateAddressDto.houseNumber() ) );
        }

        return address.build();
    }

    protected Contact createUpdateContactDtoToContact(CreateUpdateContactDto createUpdateContactDto) {
        if ( createUpdateContactDto == null ) {
            return null;
        }

        Contact.ContactBuilder contact = Contact.builder();

        contact.bossPhone( createUpdateContactDto.bossPhone() );
        contact.commonPhone( createUpdateContactDto.commonPhone() );
        contact.additionalPhone( createUpdateContactDto.additionalPhone() );

        return contact.build();
    }

    protected ReadRestaurantScheduleDto restaurantScheduleToReadRestaurantScheduleDto(RestaurantSchedule restaurantSchedule) {
        if ( restaurantSchedule == null ) {
            return null;
        }

        String id = null;

        if ( restaurantSchedule.getId() != null ) {
            id = String.valueOf( restaurantSchedule.getId() );
        }

        boolean mon = false;
        boolean tue = false;
        boolean wed = false;
        boolean thur = false;
        boolean fri = false;
        boolean sat = false;
        boolean sun = false;
        LocalTime start = null;
        LocalTime end = null;

        ReadRestaurantScheduleDto readRestaurantScheduleDto = new ReadRestaurantScheduleDto( id, mon, tue, wed, thur, fri, sat, sun, start, end );

        return readRestaurantScheduleDto;
    }

    protected List<ReadRestaurantScheduleDto> restaurantScheduleListToReadRestaurantScheduleDtoList(List<RestaurantSchedule> list) {
        if ( list == null ) {
            return null;
        }

        List<ReadRestaurantScheduleDto> list1 = new ArrayList<ReadRestaurantScheduleDto>( list.size() );
        for ( RestaurantSchedule restaurantSchedule : list ) {
            list1.add( restaurantScheduleToReadRestaurantScheduleDto( restaurantSchedule ) );
        }

        return list1;
    }

    protected ReadAddressDto addressToReadAddressDto(Address address) {
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
        if ( address.getHouseNumber() != null ) {
            houseNumber = String.valueOf( address.getHouseNumber() );
        }

        ReadAddressDto readAddressDto = new ReadAddressDto( id, city, street, houseNumber );

        return readAddressDto;
    }

    protected ReadMenuCategoryDto menuCategoryToReadMenuCategoryDto(MenuCategory menuCategory) {
        if ( menuCategory == null ) {
            return null;
        }

        String id = null;
        String name = null;

        if ( menuCategory.getId() != null ) {
            id = String.valueOf( menuCategory.getId() );
        }
        name = menuCategory.getName();

        List<ReadPositionDto> readPositionDtos = null;

        ReadMenuCategoryDto readMenuCategoryDto = new ReadMenuCategoryDto( id, name, readPositionDtos );

        return readMenuCategoryDto;
    }

    protected List<ReadMenuCategoryDto> menuCategoryListToReadMenuCategoryDtoList(List<MenuCategory> list) {
        if ( list == null ) {
            return null;
        }

        List<ReadMenuCategoryDto> list1 = new ArrayList<ReadMenuCategoryDto>( list.size() );
        for ( MenuCategory menuCategory : list ) {
            list1.add( menuCategoryToReadMenuCategoryDto( menuCategory ) );
        }

        return list1;
    }

    protected ReadContactDto contactToReadContactDto(Contact contact) {
        if ( contact == null ) {
            return null;
        }

        String id = null;
        String bossPhone = null;
        String commonPhone = null;
        String additionalPhone = null;

        if ( contact.getId() != null ) {
            id = String.valueOf( contact.getId() );
        }
        bossPhone = contact.getBossPhone();
        commonPhone = contact.getCommonPhone();
        additionalPhone = contact.getAdditionalPhone();

        ReadContactDto readContactDto = new ReadContactDto( id, bossPhone, commonPhone, additionalPhone );

        return readContactDto;
    }
}
