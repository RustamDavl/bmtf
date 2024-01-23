package ru.rstdv.bmtf.mapper;

import org.mapstruct.*;
import org.springframework.web.multipart.MultipartFile;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdateRestaurantDto;
import ru.rstdv.bmtf.dto.read.ReadRestaurantDto;
import ru.rstdv.bmtf.entity.Owner;
import ru.rstdv.bmtf.entity.Restaurant;


import java.io.IOException;


@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = {

                OwnerMapper.class
        }
)
public interface RestaurantMapper {

    @Mapping(source = "titlePhoto", target = "titlePhoto", qualifiedByName = "getBytes")
    @Mapping(source = "createUpdateAddressDto", target = "address")
    @Mapping(source = "ownerId", target = "owner", qualifiedByName = "createOwner")
    @Mapping(source = "createUpdateContactDto", target = "contact")
    @Mapping(target = "status", constant = "UNCONFIRMED")
    Restaurant toRestaurant(CreateUpdateRestaurantDto createUpdateRestaurantDto);

    @Named("getBytes")
    default byte[] getBytes(MultipartFile multipartFile) throws IOException {
        if (multipartFile == null)
            return new byte[]{};
        return multipartFile.getBytes();
    }

    @Named("createOwner")
    default Owner createOwner(String ownerId) throws IOException {
        return Owner.builder()
                .id(Long.valueOf(ownerId))
                .build();
    }

    @Mapping(source = "address", target = "readAddressDto")
    @Mapping(source = "owner", target = "readOwnerDto")
    @Mapping(source = "categories", target = "readMenuCategoryDtos")
    @Mapping(source = "contact", target = "readContactDto")
    ReadRestaurantDto toReadRestaurantDto(Restaurant restaurant);
}
