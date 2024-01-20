package ru.rstdv.bmtf.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdateRestaurantDto;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdateRestaurantScheduleDto;
import ru.rstdv.bmtf.dto.read.ReadRestaurantDto;
import ru.rstdv.bmtf.entity.Owner;
import ru.rstdv.bmtf.entity.Restaurant;
import ru.rstdv.bmtf.entity.RestaurantSchedule;

import java.io.IOException;
import java.util.List;

@Mapper(componentModel = "spring", //injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = RestaurantScheduleMapperImpl.class)
public interface RestaurantMapper {

    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

    @Mapping(source = "titlePhoto", target = "titlePhoto", qualifiedByName = "getBytes")
    @Mapping(source = "createUpdateRestaurantScheduleDtos", target = "restaurantSchedules")
    @Mapping(source = "createUpdateAddressDto", target = "address")
    @Mapping(source = "ownerId", target = "owner", qualifiedByName = "ownerWithId")
    @Mapping(source = "createUpdateMenuCategoryDtos", target = "categories")
    @Mapping(source = "createUpdateContactDto", target = "contact")
    Restaurant toRestaurant(CreateUpdateRestaurantDto createUpdateRestaurantDto);


    @Named("getBytes")
    default byte[] getBytes(MultipartFile multipartFile) throws IOException {
        return multipartFile.getBytes();
    }

    @Named("ownerWithId")
    default Owner ownerWithId(String ownerId) throws IOException {
        return Owner.builder()
                .id(Long.valueOf(ownerId))
                .build();
    }

    ReadRestaurantDto toReadRestaurantDto(Restaurant restaurant);
}
