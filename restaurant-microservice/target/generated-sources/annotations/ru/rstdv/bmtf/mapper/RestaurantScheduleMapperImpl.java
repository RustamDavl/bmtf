package ru.rstdv.bmtf.mapper;

import java.time.LocalTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdateRestaurantScheduleDto;
import ru.rstdv.bmtf.dto.read.ReadRestaurantScheduleDto;
import ru.rstdv.bmtf.entity.RestaurantSchedule;
import ru.rstdv.bmtf.entity.embeddable.WeekDays;
import ru.rstdv.bmtf.entity.embeddable.WorkingHours;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-23T21:21:23+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class RestaurantScheduleMapperImpl implements RestaurantScheduleMapper {

    @Override
    public RestaurantSchedule toRestaurantSchedule(CreateUpdateRestaurantScheduleDto createUpdateRestaurantScheduleDto) {
        if ( createUpdateRestaurantScheduleDto == null ) {
            return null;
        }

        RestaurantSchedule.RestaurantScheduleBuilder restaurantSchedule = RestaurantSchedule.builder();

        restaurantSchedule.weekDays( createUpdateRestaurantScheduleDtoToWeekDays( createUpdateRestaurantScheduleDto ) );
        restaurantSchedule.workingHours( createUpdateRestaurantScheduleDtoToWorkingHours( createUpdateRestaurantScheduleDto ) );

        return restaurantSchedule.build();
    }

    @Override
    public ReadRestaurantScheduleDto toReadRestaurantScheduleDto(RestaurantSchedule restaurantSchedule) {
        if ( restaurantSchedule == null ) {
            return null;
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
        String id = null;

        Boolean mon1 = restaurantScheduleWeekDaysMon( restaurantSchedule );
        if ( mon1 != null ) {
            mon = mon1;
        }
        Boolean tue1 = restaurantScheduleWeekDaysTue( restaurantSchedule );
        if ( tue1 != null ) {
            tue = tue1;
        }
        Boolean wed1 = restaurantScheduleWeekDaysWed( restaurantSchedule );
        if ( wed1 != null ) {
            wed = wed1;
        }
        Boolean thur1 = restaurantScheduleWeekDaysThur( restaurantSchedule );
        if ( thur1 != null ) {
            thur = thur1;
        }
        Boolean fri1 = restaurantScheduleWeekDaysFri( restaurantSchedule );
        if ( fri1 != null ) {
            fri = fri1;
        }
        Boolean sat1 = restaurantScheduleWeekDaysSat( restaurantSchedule );
        if ( sat1 != null ) {
            sat = sat1;
        }
        Boolean sun1 = restaurantScheduleWeekDaysSun( restaurantSchedule );
        if ( sun1 != null ) {
            sun = sun1;
        }
        start = restaurantScheduleWorkingHoursStart( restaurantSchedule );
        end = restaurantScheduleWorkingHoursEnd( restaurantSchedule );
        if ( restaurantSchedule.getId() != null ) {
            id = String.valueOf( restaurantSchedule.getId() );
        }

        ReadRestaurantScheduleDto readRestaurantScheduleDto = new ReadRestaurantScheduleDto( id, mon, tue, wed, thur, fri, sat, sun, start, end );

        return readRestaurantScheduleDto;
    }

    protected WeekDays createUpdateRestaurantScheduleDtoToWeekDays(CreateUpdateRestaurantScheduleDto createUpdateRestaurantScheduleDto) {
        if ( createUpdateRestaurantScheduleDto == null ) {
            return null;
        }

        WeekDays.WeekDaysBuilder weekDays = WeekDays.builder();

        weekDays.mon( createUpdateRestaurantScheduleDto.mon() );
        weekDays.tue( createUpdateRestaurantScheduleDto.tue() );
        weekDays.wed( createUpdateRestaurantScheduleDto.wed() );
        weekDays.thur( createUpdateRestaurantScheduleDto.thur() );
        weekDays.fri( createUpdateRestaurantScheduleDto.fri() );
        weekDays.sat( createUpdateRestaurantScheduleDto.sat() );
        weekDays.sun( createUpdateRestaurantScheduleDto.sun() );

        return weekDays.build();
    }

    protected WorkingHours createUpdateRestaurantScheduleDtoToWorkingHours(CreateUpdateRestaurantScheduleDto createUpdateRestaurantScheduleDto) {
        if ( createUpdateRestaurantScheduleDto == null ) {
            return null;
        }

        WorkingHours.WorkingHoursBuilder workingHours = WorkingHours.builder();

        workingHours.start( createUpdateRestaurantScheduleDto.beginTime() );
        workingHours.end( createUpdateRestaurantScheduleDto.endTime() );

        return workingHours.build();
    }

    private Boolean restaurantScheduleWeekDaysMon(RestaurantSchedule restaurantSchedule) {
        if ( restaurantSchedule == null ) {
            return null;
        }
        WeekDays weekDays = restaurantSchedule.getWeekDays();
        if ( weekDays == null ) {
            return null;
        }
        Boolean mon = weekDays.getMon();
        if ( mon == null ) {
            return null;
        }
        return mon;
    }

    private Boolean restaurantScheduleWeekDaysTue(RestaurantSchedule restaurantSchedule) {
        if ( restaurantSchedule == null ) {
            return null;
        }
        WeekDays weekDays = restaurantSchedule.getWeekDays();
        if ( weekDays == null ) {
            return null;
        }
        Boolean tue = weekDays.getTue();
        if ( tue == null ) {
            return null;
        }
        return tue;
    }

    private Boolean restaurantScheduleWeekDaysWed(RestaurantSchedule restaurantSchedule) {
        if ( restaurantSchedule == null ) {
            return null;
        }
        WeekDays weekDays = restaurantSchedule.getWeekDays();
        if ( weekDays == null ) {
            return null;
        }
        Boolean wed = weekDays.getWed();
        if ( wed == null ) {
            return null;
        }
        return wed;
    }

    private Boolean restaurantScheduleWeekDaysThur(RestaurantSchedule restaurantSchedule) {
        if ( restaurantSchedule == null ) {
            return null;
        }
        WeekDays weekDays = restaurantSchedule.getWeekDays();
        if ( weekDays == null ) {
            return null;
        }
        Boolean thur = weekDays.getThur();
        if ( thur == null ) {
            return null;
        }
        return thur;
    }

    private Boolean restaurantScheduleWeekDaysFri(RestaurantSchedule restaurantSchedule) {
        if ( restaurantSchedule == null ) {
            return null;
        }
        WeekDays weekDays = restaurantSchedule.getWeekDays();
        if ( weekDays == null ) {
            return null;
        }
        Boolean fri = weekDays.getFri();
        if ( fri == null ) {
            return null;
        }
        return fri;
    }

    private Boolean restaurantScheduleWeekDaysSat(RestaurantSchedule restaurantSchedule) {
        if ( restaurantSchedule == null ) {
            return null;
        }
        WeekDays weekDays = restaurantSchedule.getWeekDays();
        if ( weekDays == null ) {
            return null;
        }
        Boolean sat = weekDays.getSat();
        if ( sat == null ) {
            return null;
        }
        return sat;
    }

    private Boolean restaurantScheduleWeekDaysSun(RestaurantSchedule restaurantSchedule) {
        if ( restaurantSchedule == null ) {
            return null;
        }
        WeekDays weekDays = restaurantSchedule.getWeekDays();
        if ( weekDays == null ) {
            return null;
        }
        Boolean sun = weekDays.getSun();
        if ( sun == null ) {
            return null;
        }
        return sun;
    }

    private LocalTime restaurantScheduleWorkingHoursStart(RestaurantSchedule restaurantSchedule) {
        if ( restaurantSchedule == null ) {
            return null;
        }
        WorkingHours workingHours = restaurantSchedule.getWorkingHours();
        if ( workingHours == null ) {
            return null;
        }
        LocalTime start = workingHours.getStart();
        if ( start == null ) {
            return null;
        }
        return start;
    }

    private LocalTime restaurantScheduleWorkingHoursEnd(RestaurantSchedule restaurantSchedule) {
        if ( restaurantSchedule == null ) {
            return null;
        }
        WorkingHours workingHours = restaurantSchedule.getWorkingHours();
        if ( workingHours == null ) {
            return null;
        }
        LocalTime end = workingHours.getEnd();
        if ( end == null ) {
            return null;
        }
        return end;
    }
}
