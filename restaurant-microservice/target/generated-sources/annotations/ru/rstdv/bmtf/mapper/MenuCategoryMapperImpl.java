package ru.rstdv.bmtf.mapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdateMenuCategoryDto;
import ru.rstdv.bmtf.dto.read.ReadMenuCategoryDto;
import ru.rstdv.bmtf.dto.read.ReadPositionDto;
import ru.rstdv.bmtf.entity.MenuCategory;
import ru.rstdv.bmtf.entity.Position;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-23T21:21:23+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class MenuCategoryMapperImpl implements MenuCategoryMapper {

    private final PositionMapper positionMapper;

    @Autowired
    public MenuCategoryMapperImpl(PositionMapper positionMapper) {

        this.positionMapper = positionMapper;
    }

    @Override
    public MenuCategory toMenuCategory(CreateUpdateMenuCategoryDto createUpdateMenuCategoryDto) {
        if ( createUpdateMenuCategoryDto == null ) {
            return null;
        }

        MenuCategory.MenuCategoryBuilder menuCategory = MenuCategory.builder();

        try {
            menuCategory.restaurant( createRestaurant( createUpdateMenuCategoryDto.restaurantId() ) );
        }
        catch ( IOException e ) {
            throw new RuntimeException( e );
        }
        menuCategory.name( createUpdateMenuCategoryDto.name() );

        return menuCategory.build();
    }

    @Override
    public ReadMenuCategoryDto toReadMenuCategoryDto(MenuCategory menuCategory) {
        if ( menuCategory == null ) {
            return null;
        }

        List<ReadPositionDto> readPositionDtos = null;
        String id = null;
        String name = null;

        readPositionDtos = positionListToReadPositionDtoList( menuCategory.getPositions() );
        if ( menuCategory.getId() != null ) {
            id = String.valueOf( menuCategory.getId() );
        }
        name = menuCategory.getName();

        ReadMenuCategoryDto readMenuCategoryDto = new ReadMenuCategoryDto( id, name, readPositionDtos );

        return readMenuCategoryDto;
    }

    protected List<ReadPositionDto> positionListToReadPositionDtoList(List<Position> list) {
        if ( list == null ) {
            return null;
        }

        List<ReadPositionDto> list1 = new ArrayList<ReadPositionDto>( list.size() );
        for ( Position position : list ) {
            list1.add( positionMapper.toReadPositionDto( position ) );
        }

        return list1;
    }
}
