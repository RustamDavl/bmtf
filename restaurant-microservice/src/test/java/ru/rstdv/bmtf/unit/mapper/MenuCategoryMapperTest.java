package ru.rstdv.bmtf.unit.mapper;

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


@SpringBootTest(classes = {MenuCategoryMapperImpl.class, PositionMapperImpl.class})
public class MenuCategoryMapperTest {

    @Autowired
    private MenuCategoryMapper menuCategoryMapper;


    @Test
    void toMenuCategory() {
        var givenDto = new CreateUpdateMenuCategoryDto(
                "hot",
                List.of(new CreateUpdatePositionDto(
                                "soup",
                                new MockMultipartFile("test", new byte[]{1, 42, 53, 24}),
                                "chilly soup",
                                "1000"
                        ),
                        new CreateUpdatePositionDto(
                                "coffee",
                                new MockMultipartFile("test", new byte[]{1, 42, 53, 24}),
                                "americano",
                                "400"
                        )

                )
        );

        var actualDto = menuCategoryMapper.toMenuCategory(givenDto);

        System.out.println(actualDto.getPositions());

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

        System.out.println(actualResult);
    }
}
