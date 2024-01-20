package ru.rstdv.bmtf.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.web.multipart.MultipartFile;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdatePositionDto;
import ru.rstdv.bmtf.dto.read.ReadPositionDto;
import ru.rstdv.bmtf.entity.Position;

import java.io.IOException;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PositionMapper {

    PositionMapper INSTANCE = Mappers.getMapper(PositionMapper.class);

    @Mapping(source = "photo", target = "photo", qualifiedByName = "getPhotoBytes")
    Position toPosition(CreateUpdatePositionDto createUpdatePositionDto);

    @Named("getPhotoBytes")
    default byte[] getPhotoBytes(MultipartFile multipartFile) throws IOException {
        return multipartFile.getBytes();
    }

    ReadPositionDto toReadPositionDto(Position position);

}
