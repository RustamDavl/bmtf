package ru.rstdv.bmtf.mapper;

import org.mapstruct.*;
import org.springframework.web.multipart.MultipartFile;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdateRestaurantDto;
import ru.rstdv.bmtf.dto.read.ReadRestaurantDto;
import ru.rstdv.bmtf.entity.Owner;
import ru.rstdv.bmtf.entity.Restaurant;


import java.io.IOException;


@Mapper(componentModel = "spring",//injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = {
                RestaurantScheduleMapperImpl.class,
                OwnerMapperImpl.class,
                MenuCategoryMapperImpl.class
        }
)
public interface RestaurantMapper {

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

    @Mapping(source = "restaurantSchedules", target = "restaurantSchedules")
    @Mapping(source = "address", target = "readAddressDto")
    @Mapping(source = "owner", target = "readOwnerDto")
    @Mapping(source = "categories", target = "readMenuCategoryDtos")
    @Mapping(source = "contact", target = "readContactDto")
    ReadRestaurantDto toReadRestaurantDto(Restaurant restaurant);
}
