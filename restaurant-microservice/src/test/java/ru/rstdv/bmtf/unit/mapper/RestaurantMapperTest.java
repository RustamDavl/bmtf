package ru.rstdv.bmtf.unit.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.testcontainers.shaded.org.checkerframework.checker.units.qual.A;
import ru.rstdv.bmtf.dto.createupdate.*;
import ru.rstdv.bmtf.mapper.*;

import java.time.LocalTime;
import java.util.List;

@SpringBootTest(classes = {
        RestaurantMapperImpl.class,
        AddressMapperImpl.class,
        ContactMapperImpl.class,
        MenuCategoryMapperImpl.class,
        OwnerMapperImpl.class,
        PositionMapperImpl.class,
        RestaurantScheduleMapperImpl.class
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
                List.of(new CreateUpdateRestaurantScheduleDto(
                        true,
                        true,
                        true,
                        true,
                        true,
                        true,
                        true,
                        LocalTime.of(8, 0),
                        LocalTime.of(23, 0)
                )),
                new CreateUpdateAddressDto(
                        "Kazan",
                        "Ametevo",
                        "16"
                ),
                "CARD",
                "1",
                List.of(new CreateUpdateMenuCategoryDto(
                        "hot",
                        List.of(new CreateUpdatePositionDto(
                                "soup",
                                new MockMultipartFile("test", new byte[]{1, 42, 53, 24}),
                                "chilly soup",
                                "1000"
                        ))
                )),
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
}
