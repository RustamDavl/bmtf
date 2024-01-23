package ru.rstdv.bmtf.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.web.multipart.MultipartFile;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdatePositionDto;
import ru.rstdv.bmtf.dto.read.ReadPositionDto;
import ru.rstdv.bmtf.entity.MenuCategory;
import ru.rstdv.bmtf.entity.Position;
import ru.rstdv.bmtf.entity.Restaurant;

import java.io.IOException;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PositionMapper {

    @Mapping(source = "photo", target = "photo", qualifiedByName = "getPhotoBytes")
    @Mapping(source = "menuCategoryId", target = "category", qualifiedByName = "createMenuCategory")
    Position toPosition(CreateUpdatePositionDto createUpdatePositionDto);

    @Named("getPhotoBytes")
    default byte[] getPhotoBytes(MultipartFile multipartFile) throws IOException {
        if (multipartFile == null)
            return new byte[]{};
        return multipartFile.getBytes();
    }

    @Named("createMenuCategory")
    default MenuCategory createMenuCategory(String menuCategoryId) throws IOException {
        return MenuCategory.builder()
                .id(Long.valueOf(menuCategoryId))
                .build();
    }

    ReadPositionDto toReadPositionDto(Position position);

}
