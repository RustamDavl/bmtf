package ru.rstdv.bmtf.unit.mapper;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.rstdv.bmtf.dto.read.ReadRestaurantSchedule;
import ru.rstdv.bmtf.entity.RestaurantSchedule;
import ru.rstdv.bmtf.entity.embeddable.WeekDays;
import ru.rstdv.bmtf.entity.embeddable.WorkingHours;
import ru.rstdv.bmtf.mapper.RestaurantScheduleMapper;

import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

public class RestaurantScheduleMapperTest {

    private RestaurantScheduleMapper restaurantScheduleMapper;

    @BeforeEach
    void setUp() {
        restaurantScheduleMapper = RestaurantScheduleMapper.INSTANCE;
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

        var expectedResult = new ReadRestaurantSchedule(
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

        var actualResult = restaurantScheduleMapper.toReadRestaurantSchedule(restaurantSchedule);

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
