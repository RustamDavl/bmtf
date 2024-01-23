package ru.rstdv.bmtf.mapper;

import org.mapstruct.*;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdateMenuCategoryDto;
import ru.rstdv.bmtf.dto.read.ReadMenuCategoryDto;
import ru.rstdv.bmtf.entity.MenuCategory;
import ru.rstdv.bmtf.entity.Owner;
import ru.rstdv.bmtf.entity.Restaurant;

import java.io.IOException;

@Mapper(
        componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = PositionMapper.class)
public interface MenuCategoryMapper {
    @Mapping(source = "restaurantId", target = "restaurant", qualifiedByName = "createRestaurant")
    MenuCategory toMenuCategory(CreateUpdateMenuCategoryDto createUpdateMenuCategoryDto);

    @Named("createRestaurant")
    default Restaurant createRestaurant(String restaurantId) throws IOException {
        return Restaurant.builder()
                .id(Long.valueOf(restaurantId))
                .build();
    }

    @Mapping(source = "positions", target = "readPositionDtos")
    ReadMenuCategoryDto toReadMenuCategoryDto(MenuCategory menuCategory);
}
