package ru.rstdv.bmtf.unit.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.testcontainers.shaded.org.checkerframework.checker.units.qual.A;
import ru.rstdv.bmtf.dto.createupdate.*;
import ru.rstdv.bmtf.entity.*;
import ru.rstdv.bmtf.entity.embeddable.PaymentMethod;
import ru.rstdv.bmtf.entity.embeddable.RestaurantStatus;
import ru.rstdv.bmtf.entity.embeddable.WeekDays;
import ru.rstdv.bmtf.entity.embeddable.WorkingHours;
import ru.rstdv.bmtf.mapper.*;

import java.time.LocalTime;
import java.util.List;

@SpringBootTest(classes = {
        RestaurantMapperImpl.class,
        AddressMapperImpl.class,
        ContactMapperImpl.class,
        OwnerMapperImpl.class,
})
public class RestaurantMapperTest {

    @Autowired
    private RestaurantMapper restaurantMapper;


    @Test
    void toRestaurant() {
        var createUpdateRestaurantDto = new CreateUpdateRestaurantDto(
                "test@gmail.com",
                new MockMultipartFile("image name", new byte[0]),
                "test",
                new CreateUpdateAddressDto(
                        "Kazan",
                        "Ametevo",
                        "16"
                ),
                "CARD",
                "1",
                new CreateUpdateContactDto(
                        "89179209061",
                        "89179209061",
                        null
                )
        );

        var actualResult = restaurantMapper.toRestaurant(createUpdateRestaurantDto);

        System.out.println(actualResult);

        System.out.println(actualResult.getRestaurantSchedules());
        System.out.println(actualResult.getAddress());
        System.out.println(actualResult.getCategories());
        System.out.println(actualResult.getContact());
        System.out.println(actualResult.getPaymentMethod());

    }

    @Test
    void toReadRestaurantDto() {
        var restaurant = Restaurant.builder()
                .id(1L)
                .email("test@gmail.com")
                .titlePhoto(new byte[]{1, 42, 53, 24})
                .name("tasty and dot")

                .restaurantSchedules(List.of(
                                RestaurantSchedule.builder()
                                        .weekDays(WeekDays.builder()
                                                .mon(true)
                                                .tue(true)
                                                .wed(true)
                                                .thur(true)
                                                .fri(true)
                                                .sat(false)
                                                .sun(false)
                                                .build())
                                        .workingHours(WorkingHours.builder()
                                                .start(LocalTime.of(8, 0))
                                                .end(LocalTime.of(23, 0))
                                                .build()
                                        )
                                        .build(),
                                RestaurantSchedule.builder()
                                        .weekDays(WeekDays.builder()
                                                .mon(false)
                                                .tue(false)
                                                .wed(false)
                                                .thur(false)
                                                .fri(false)
                                                .sat(true)
                                                .sun(true)
                                                .build())
                                        .workingHours(WorkingHours.builder()
                                                .start(LocalTime.of(10, 0))
                                                .end(LocalTime.of(21, 0))
                                                .build()
                                        )
                                        .build()
                        )
                )
                .address(
                        Address.builder()
                                .city("Kazan")
                                .street("Ametevo")
                                .houseNumber(Short.valueOf("16"))
                                .build())
                .paymentMethod(PaymentMethod.CASH_CARD)
                .owner(
                        Owner.builder()
                                .id(1L)
                                .email("owner@gmail.com")
                                .phone("89179208080")
                                .build())
                .categories(
                        List.of(
                                MenuCategory.builder()
                                        .name("hot")
                                        .positions(
                                                List.of(
                                                        Position.builder()
                                                                .id(1L)
                                                                .name("position1")
                                                                .build(),
                                                        Position.builder()
                                                                .id(2L)
                                                                .name("position2")
                                                                .build()
                                                )
                                        )
                                        .build()
                        )
                )
                .contact(
                        Contact.builder()
                                .id(1L)
                                .bossPhone("89179209061")
                                .additionalPhone("89179209061")
                                .commonPhone("89179209061")
                                .build()
                )
                .status(
                        RestaurantStatus.UNCONFIRMED
                )
                .build();

        var actualResult = restaurantMapper.toReadRestaurantDto(restaurant);

        System.out.println(actualResult);
        System.out.println(actualResult.restaurantSchedules());
        System.out.println(actualResult.readContactDto());
        System.out.println(actualResult.readAddressDto());
        System.out.println(actualResult.paymentMethod());
        System.out.println(actualResult.readMenuCategoryDtos());
        System.out.println(actualResult.readOwnerDto());
    }
}
