package ru.rstdv.bmtf.unit.mapper;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ActiveProfiles;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdateMenuCategoryDto;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdatePositionDto;
import ru.rstdv.bmtf.entity.MenuCategory;
import ru.rstdv.bmtf.entity.Position;
import ru.rstdv.bmtf.mapper.MenuCategoryMapper;
import ru.rstdv.bmtf.mapper.MenuCategoryMapperImpl;
import ru.rstdv.bmtf.mapper.PositionMapperImpl;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(classes = {MenuCategoryMapperImpl.class, PositionMapperImpl.class})
public class MenuCategoryMapperTest {

    @Autowired
    private MenuCategoryMapper menuCategoryMapper;


    @Test
    void toMenuCategory() {
        var createUpdateMenuCategoryDto = new CreateUpdateMenuCategoryDto(
                "hot",
                "1"
        );

        var menuCategory = MenuCategory.builder()
                .id(1L)
                .build();

        var actualMenuCategoryDto = menuCategoryMapper.toMenuCategory(createUpdateMenuCategoryDto);
        assertThat(actualMenuCategoryDto.getName()).isEqualTo(createUpdateMenuCategoryDto.name());

        assertThat(actualMenuCategoryDto.getRestaurant().getId()).isEqualTo(menuCategory.getId());


    }

    @Test
    void toReadMenuCategory() {
        var menuCategory = MenuCategory.builder()
                .name("hot")
                .positions(
                        List.of(
                                Position.builder()
                                        .id(1L)
                                        .name("position1")
                                        .build(),
                                Position.builder()
                                        .id(2L)
                                        .name("position2")
                                        .build()
                        )
                )
                .build();

        var actualResult = menuCategoryMapper.toReadMenuCategoryDto(menuCategory);

        assertThat(actualResult.name()).isEqualTo(menuCategory.getName());
        assertThat(actualResult.readPositionDtos()).hasSize(2);
        assertThat(actualResult.readPositionDtos().get(0).name()).isEqualTo(menuCategory.getPositions().get(0).getName());
    }
}
