package ru.rstdv.bmtf.mapper;

import java.io.IOException;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdatePositionDto;
import ru.rstdv.bmtf.dto.read.ReadPositionDto;
import ru.rstdv.bmtf.entity.Position;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-23T21:21:23+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class PositionMapperImpl implements PositionMapper {

    @Override
    public Position toPosition(CreateUpdatePositionDto createUpdatePositionDto) {
        if ( createUpdatePositionDto == null ) {
            return null;
        }

        Position.PositionBuilder position = Position.builder();

        try {
            position.photo( getPhotoBytes( createUpdatePositionDto.photo() ) );
        }
        catch ( IOException e ) {
            throw new RuntimeException( e );
        }
        try {
            position.category( createMenuCategory( createUpdatePositionDto.menuCategoryId() ) );
        }
        catch ( IOException e ) {
            throw new RuntimeException( e );
        }
        position.name( createUpdatePositionDto.name() );
        position.description( createUpdatePositionDto.description() );
        if ( createUpdatePositionDto.weight() != null ) {
            position.weight( Short.parseShort( createUpdatePositionDto.weight() ) );
        }

        return position.build();
    }

    @Override
    public ReadPositionDto toReadPositionDto(Position position) {
        if ( position == null ) {
            return null;
        }

        String id = null;
        String name = null;
        String description = null;
        String weight = null;

        if ( position.getId() != null ) {
            id = String.valueOf( position.getId() );
        }
        name = position.getName();
        description = position.getDescription();
        if ( position.getWeight() != null ) {
            weight = String.valueOf( position.getWeight() );
        }

        ReadPositionDto readPositionDto = new ReadPositionDto( id, name, description, weight );

        return readPositionDto;
    }
}
