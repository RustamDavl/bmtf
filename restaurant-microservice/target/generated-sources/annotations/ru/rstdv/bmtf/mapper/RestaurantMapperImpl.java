package ru.rstdv.bmtf.mapper;

import java.util.Arrays;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdateRestaurantDto;
import ru.rstdv.bmtf.entity.Restaurant;
import ru.rstdv.bmtf.entity.embeddable.PaymentMethod;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-14T22:07:32+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class RestaurantMapperImpl implements RestaurantMapper {

    @Override
    public Restaurant toRestaurant(CreateUpdateRestaurantDto createUpdateRestaurantDto) {
        if ( createUpdateRestaurantDto == null ) {
            return null;
        }

        Restaurant.RestaurantBuilder restaurant = Restaurant.builder();

        restaurant.email( createUpdateRestaurantDto.email() );
        byte[] titlePhoto = createUpdateRestaurantDto.titlePhoto();
        if ( titlePhoto != null ) {
            restaurant.titlePhoto( Arrays.copyOf( titlePhoto, titlePhoto.length ) );
        }
        restaurant.name( createUpdateRestaurantDto.name() );
        if ( createUpdateRestaurantDto.paymentMethod() != null ) {
            restaurant.paymentMethod( Enum.valueOf( PaymentMethod.class, createUpdateRestaurantDto.paymentMethod() ) );
        }

        return restaurant.build();
    }
}
