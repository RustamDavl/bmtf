package ru.rstdv.bmtf.unit.mapper;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdateRestaurantScheduleDto;
import ru.rstdv.bmtf.dto.read.ReadRestaurantScheduleDto;
import ru.rstdv.bmtf.entity.RestaurantSchedule;
import ru.rstdv.bmtf.entity.embeddable.WeekDays;
import ru.rstdv.bmtf.entity.embeddable.WorkingHours;
import ru.rstdv.bmtf.mapper.RestaurantScheduleMapper;
import ru.rstdv.bmtf.mapper.RestaurantScheduleMapperImpl;

import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = RestaurantScheduleMapperImpl.class)
public class RestaurantScheduleMapperTest {

    @Autowired
    private RestaurantScheduleMapper restaurantScheduleMapper;


    @Test
    void toRestaurantSchedule() {
        var createUpdateRestaurantSchedule = new CreateUpdateRestaurantScheduleDto(
                true,
                true,
                true,
                true,
                true,
                true,
                true,
                LocalTime.of(8, 0),
                LocalTime.of(23, 0)
        );

        var expectedResult = RestaurantSchedule.builder()
                .weekDays(WeekDays.builder()
                        .mon(true)
                        .tue(true)
                        .wed(true)
                        .thur(true)
                        .fri(true)
                        .sat(true)
                        .sun(false)
                        .build())
                .workingHours(WorkingHours.builder()
                        .start(LocalTime.of(8, 0))
                        .end(LocalTime.of(23, 0))
                        .build()
                )
                .build();

        var actualResult = restaurantScheduleMapper.toRestaurantSchedule(createUpdateRestaurantSchedule);

        System.out.println(actualResult);
    }


    @Test
    void toReadRestaurantSchedule() {
        var restaurantSchedule = RestaurantSchedule.builder()
                .weekDays(WeekDays.builder()
                        .mon(true)
                        .tue(true)
                        .wed(true)
                        .thur(true)
                        .fri(true)
                        .sat(true)
                        .sun(false)
                        .build())
                .workingHours(WorkingHours.builder()
                        .start(LocalTime.of(8, 0))
                        .end(LocalTime.of(23, 0))
                        .build()
                )
                .build();

        var expectedResult = new ReadRestaurantScheduleDto(
                "1",
                true,
                true,
                true,
                true,
                true,
                true,
                false,
                LocalTime.of(8, 0),
                LocalTime.of(23, 0)


        );

        var actualResult = restaurantScheduleMapper.toReadRestaurantScheduleDto(restaurantSchedule);

        assertThat(actualResult.mon()).isEqualTo(expectedResult.mon());
        assertThat(actualResult.tue()).isEqualTo(expectedResult.tue());
        assertThat(actualResult.wed()).isEqualTo(expectedResult.wed());
        assertThat(actualResult.thur()).isEqualTo(expectedResult.thur());
        assertThat(actualResult.fri()).isEqualTo(expectedResult.fri());
        assertThat(actualResult.sat()).isEqualTo(expectedResult.sat());
        assertThat(actualResult.sun()).isEqualTo(expectedResult.sun());
        assertThat(actualResult.start()).isEqualTo(expectedResult.start());
        assertThat(actualResult.end()).isEqualTo(expectedResult.end());
    }
}
