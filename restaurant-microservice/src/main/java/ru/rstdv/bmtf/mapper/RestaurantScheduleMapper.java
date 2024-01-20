package ru.rstdv.bmtf.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdateRestaurantScheduleDto;
import ru.rstdv.bmtf.dto.read.ReadRestaurantScheduleDto;
import ru.rstdv.bmtf.entity.RestaurantSchedule;


@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface RestaurantScheduleMapper {

    RestaurantScheduleMapper INSTANCE = Mappers.getMapper(RestaurantScheduleMapper.class);


    @Mapping(source = "mon", target = "weekDays.mon")
    @Mapping(source = "tue", target = "weekDays.tue")
    @Mapping(source = "wed", target = "weekDays.wed")
    @Mapping(source = "thur", target = "weekDays.thur")
    @Mapping(source = "fri", target = "weekDays.fri")
    @Mapping(source = "sat", target = "weekDays.sat")
    @Mapping(source = "sun", target = "weekDays.sun")
    @Mapping(source = "beginTime", target = "workingHours.start")
    @Mapping(source = "endTime", target = "workingHours.end")
    RestaurantSchedule toRestaurantSchedule(CreateUpdateRestaurantScheduleDto createUpdateRestaurantScheduleDto);

    @Mapping(target = "mon", source = "weekDays.mon")
    @Mapping(target = "tue", source = "weekDays.tue")
    @Mapping(target = "wed", source = "weekDays.wed")
    @Mapping(target = "thur", source = "weekDays.thur")
    @Mapping(target = "fri", source = "weekDays.fri")
    @Mapping(target = "sat", source = "weekDays.sat")
    @Mapping(target = "sun", source = "weekDays.sun")
    @Mapping(target = "start", source = "workingHours.start")
    @Mapping(target = "end", source = "workingHours.end")
    ReadRestaurantScheduleDto toReadRestaurantScheduleDto(RestaurantSchedule restaurantSchedule);
}
