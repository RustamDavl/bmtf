package ru.rstdv.bmtf.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdateMenuCategoryDto;
import ru.rstdv.bmtf.dto.read.ReadMenuCategoryDto;
import ru.rstdv.bmtf.entity.MenuCategory;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MenuCategoryMapper {

    MenuCategoryMapper INSTANCE = Mappers.getMapper(MenuCategoryMapper.class);

    MenuCategory toMenuCategory(CreateUpdateMenuCategoryDto createUpdateMenuCategoryDto);

    ReadMenuCategoryDto toReadMenuCategoryDto(MenuCategory menuCategory);
}
