package ru.rstdv.bmtf.mapper;

import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdateMenuCategoryDto;
import ru.rstdv.bmtf.dto.read.ReadMenuCategoryDto;
import ru.rstdv.bmtf.dto.read.ReadPositionDto;
import ru.rstdv.bmtf.entity.MenuCategory;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-14T22:07:32+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class MenuCategoryMapperImpl implements MenuCategoryMapper {

    @Override
    public MenuCategory toMenuCategory(CreateUpdateMenuCategoryDto createUpdateMenuCategoryDto) {
        if ( createUpdateMenuCategoryDto == null ) {
            return null;
        }

        MenuCategory.MenuCategoryBuilder menuCategory = MenuCategory.builder();

        menuCategory.name( createUpdateMenuCategoryDto.name() );

        return menuCategory.build();
    }

    @Override
    public ReadMenuCategoryDto toReadMenuCategoryDto(MenuCategory menuCategory) {
        if ( menuCategory == null ) {
            return null;
        }

        String id = null;
        String name = null;

        if ( menuCategory.getId() != null ) {
            id = String.valueOf( menuCategory.getId() );
        }
        name = menuCategory.getName();

        List<ReadPositionDto> readPositionDtos = null;

        ReadMenuCategoryDto readMenuCategoryDto = new ReadMenuCategoryDto( id, name, readPositionDtos );

        return readMenuCategoryDto;
    }
}
