package ru.rstdv.bmtf.dto.createupdate;

public record CreateUpdateRestaurantScheduleDto(
        boolean mon,
        boolean tue,
        boolean wed,
        boolean thur,
        boolean fri,
        boolean sun,

        String beginTime,

        String endTime
) {
}
