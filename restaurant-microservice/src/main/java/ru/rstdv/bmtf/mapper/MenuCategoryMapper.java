package ru.rstdv.bmtf.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdateMenuCategoryDto;
import ru.rstdv.bmtf.dto.read.ReadMenuCategoryDto;
import ru.rstdv.bmtf.entity.MenuCategory;

@Mapper(
        componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
uses = PositionMapper.class)
public interface MenuCategoryMapper {


    @Mapping(source = "createUpdatePositionDto", target = "positions")
    MenuCategory toMenuCategory(CreateUpdateMenuCategoryDto createUpdateMenuCategoryDto);


    @Mapping(source = "positions", target = "readPositionDtos")
    ReadMenuCategoryDto toReadMenuCategoryDto(MenuCategory menuCategory);
}
