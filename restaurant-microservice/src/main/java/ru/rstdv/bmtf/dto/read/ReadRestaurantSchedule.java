package ru.rstdv.bmtf.dto.read;

import java.time.LocalTime;

public record ReadRestaurantSchedule(
        String id,
        boolean mon,
        boolean tue,
        boolean wed,
        boolean thur,
        boolean fri,
        boolean sat,
        boolean sun,
        LocalTime start,
        LocalTime end

) {
}
