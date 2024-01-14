package ru.rstdv.bmtf.dto.createupdate;

import java.time.LocalTime;

public record CreateUpdateRestaurantScheduleDto(
        boolean mon,
        boolean tue,
        boolean wed,
        boolean thur,
        boolean fri,
        boolean sat,
        boolean sun,

        LocalTime beginTime,

        LocalTime endTime
) {
}
