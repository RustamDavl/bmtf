package ru.rstdv.bmtf.unit.mapper;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdatePositionDto;
import ru.rstdv.bmtf.dto.read.ReadPositionDto;
import ru.rstdv.bmtf.entity.Position;
import ru.rstdv.bmtf.mapper.PositionMapper;
import ru.rstdv.bmtf.mapper.PositionMapperImpl;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = PositionMapperImpl.class)
public class PositionMapperTest {

    @Autowired
    private PositionMapper positionMapper;


    @Test
    void toPosition() throws IOException {
        var createUpdatePositionDto = new CreateUpdatePositionDto(
                "soup",
                new MockMultipartFile("test", new byte[]{1, 42, 53, 24}),
                "chilly soup",
                "1000"
        );

        var expectedResult = Position.builder()
                .name("soup")
                .description("chilly soup")
                .weight(Short.valueOf("1000"))
                .photo(new byte[]{1, 42, 53, 24})
                .build();
        var actualResult = positionMapper.toPosition(createUpdatePositionDto);

        assertThat(actualResult.getName()).isEqualTo(expectedResult.getName());
        assertThat(actualResult.getDescription()).isEqualTo(expectedResult.getDescription());
        assertThat(actualResult.getWeight()).isEqualTo(expectedResult.getWeight());
        assertThat(actualResult.getPhoto()).isEqualTo(expectedResult.getPhoto());


    }

    @Test
    void toReadPositionDto() {
        var position = Position.builder()
                .id(1L)
                .weight((short) 1000)
                .description("test")
                .name("name")
                .photo(new byte[]{1, 2, 4, 65})
                .build();
        var expectedResult = new ReadPositionDto(
                "1",
                "name",
                "test",
                "1000"
        );
        var actualPosition = positionMapper.toReadPositionDto(position);

        assertThat(actualPosition.id()).isEqualTo(expectedResult.id());
        assertThat(actualPosition.name()).isEqualTo(expectedResult.name());
        assertThat(actualPosition.description()).isEqualTo(expectedResult.description());
        assertThat(actualPosition.weight()).isEqualTo(expectedResult.weight());
        System.out.println(actualPosition);
    }
}
