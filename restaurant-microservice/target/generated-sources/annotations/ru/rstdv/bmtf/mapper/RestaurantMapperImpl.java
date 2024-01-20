package ru.rstdv.bmtf.mapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdateAddressDto;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdateContactDto;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdateMenuCategoryDto;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdateRestaurantDto;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdateRestaurantScheduleDto;
import ru.rstdv.bmtf.dto.read.ReadAddressDto;
import ru.rstdv.bmtf.dto.read.ReadContactDto;
import ru.rstdv.bmtf.dto.read.ReadMenuCategoryDto;
import ru.rstdv.bmtf.dto.read.ReadOwnerDto;
import ru.rstdv.bmtf.dto.read.ReadRestaurantDto;
import ru.rstdv.bmtf.dto.read.ReadRestaurantScheduleDto;
import ru.rstdv.bmtf.entity.Address;
import ru.rstdv.bmtf.entity.Contact;
import ru.rstdv.bmtf.entity.MenuCategory;
import ru.rstdv.bmtf.entity.Restaurant;
import ru.rstdv.bmtf.entity.RestaurantSchedule;
import ru.rstdv.bmtf.entity.embeddable.PaymentMethod;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-20T21:17:44+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class RestaurantMapperImpl implements RestaurantMapper {

    @Autowired
    private RestaurantScheduleMapperImpl restaurantScheduleMapperImpl;

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
        restaurant.restaurantSchedules( createUpdateRestaurantScheduleDtoListToRestaurantScheduleList( createUpdateRestaurantDto.createUpdateRestaurantScheduleDtos() ) );
        restaurant.address( createUpdateAddressDtoToAddress( createUpdateRestaurantDto.createUpdateAddressDto() ) );
        try {
            restaurant.owner( ownerWithId( createUpdateRestaurantDto.ownerId() ) );
        }
        catch ( IOException e ) {
            throw new RuntimeException( e );
        }
        restaurant.categories( createUpdateMenuCategoryDtoListToMenuCategoryList( createUpdateRestaurantDto.createUpdateMenuCategoryDtos() ) );
        restaurant.contact( createUpdateContactDtoToContact( createUpdateRestaurantDto.createUpdateContactDto() ) );
        restaurant.email( createUpdateRestaurantDto.email() );
        restaurant.name( createUpdateRestaurantDto.name() );
        if ( createUpdateRestaurantDto.paymentMethod() != null ) {
            restaurant.paymentMethod( Enum.valueOf( PaymentMethod.class, createUpdateRestaurantDto.paymentMethod() ) );
        }

        return restaurant.build();
    }

    @Override
    public ReadRestaurantDto toReadRestaurantDto(Restaurant restaurant) {
        if ( restaurant == null ) {
            return null;
        }

        String id = null;
        String email = null;
        byte[] titlePhoto = null;
        String name = null;
        List<ReadRestaurantScheduleDto> restaurantSchedules = null;
        String paymentMethod = null;
        String status = null;

        if ( restaurant.getId() != null ) {
            id = String.valueOf( restaurant.getId() );
        }
        email = restaurant.getEmail();
        byte[] titlePhoto1 = restaurant.getTitlePhoto();
        if ( titlePhoto1 != null ) {
            titlePhoto = Arrays.copyOf( titlePhoto1, titlePhoto1.length );
        }
        name = restaurant.getName();
        restaurantSchedules = restaurantScheduleListToReadRestaurantScheduleDtoList( restaurant.getRestaurantSchedules() );
        if ( restaurant.getPaymentMethod() != null ) {
            paymentMethod = restaurant.getPaymentMethod().name();
        }
        if ( restaurant.getStatus() != null ) {
            status = restaurant.getStatus().name();
        }

        ReadAddressDto readAddressDto = null;
        ReadOwnerDto readOwnerDto = null;
        List<ReadMenuCategoryDto> readMenuCategoryDtos = null;
        ReadContactDto readContactDto = null;

        ReadRestaurantDto readRestaurantDto = new ReadRestaurantDto( id, email, titlePhoto, name, restaurantSchedules, readAddressDto, paymentMethod, readOwnerDto, readMenuCategoryDtos, readContactDto, status );

        return readRestaurantDto;
    }

    protected List<RestaurantSchedule> createUpdateRestaurantScheduleDtoListToRestaurantScheduleList(List<CreateUpdateRestaurantScheduleDto> list) {
        if ( list == null ) {
            return null;
        }

        List<RestaurantSchedule> list1 = new ArrayList<RestaurantSchedule>( list.size() );
        for ( CreateUpdateRestaurantScheduleDto createUpdateRestaurantScheduleDto : list ) {
            list1.add( restaurantScheduleMapperImpl.toRestaurantSchedule( createUpdateRestaurantScheduleDto ) );
        }

        return list1;
    }

    protected Address createUpdateAddressDtoToAddress(CreateUpdateAddressDto createUpdateAddressDto) {
        if ( createUpdateAddressDto == null ) {
            return null;
        }

        Address.AddressBuilder address = Address.builder();

        address.city( createUpdateAddressDto.city() );
        address.street( createUpdateAddressDto.street() );
        address.houseNumber( createUpdateAddressDto.houseNumber() );

        return address.build();
    }

    protected MenuCategory createUpdateMenuCategoryDtoToMenuCategory(CreateUpdateMenuCategoryDto createUpdateMenuCategoryDto) {
        if ( createUpdateMenuCategoryDto == null ) {
            return null;
        }

        MenuCategory.MenuCategoryBuilder menuCategory = MenuCategory.builder();

        menuCategory.name( createUpdateMenuCategoryDto.name() );

        return menuCategory.build();
    }

    protected List<MenuCategory> createUpdateMenuCategoryDtoListToMenuCategoryList(List<CreateUpdateMenuCategoryDto> list) {
        if ( list == null ) {
            return null;
        }

        List<MenuCategory> list1 = new ArrayList<MenuCategory>( list.size() );
        for ( CreateUpdateMenuCategoryDto createUpdateMenuCategoryDto : list ) {
            list1.add( createUpdateMenuCategoryDtoToMenuCategory( createUpdateMenuCategoryDto ) );
        }

        return list1;
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

    protected List<ReadRestaurantScheduleDto> restaurantScheduleListToReadRestaurantScheduleDtoList(List<RestaurantSchedule> list) {
        if ( list == null ) {
            return null;
        }

        List<ReadRestaurantScheduleDto> list1 = new ArrayList<ReadRestaurantScheduleDto>( list.size() );
        for ( RestaurantSchedule restaurantSchedule : list ) {
            list1.add( restaurantScheduleMapperImpl.toReadRestaurantScheduleDto( restaurantSchedule ) );
        }

        return list1;
    }
}
