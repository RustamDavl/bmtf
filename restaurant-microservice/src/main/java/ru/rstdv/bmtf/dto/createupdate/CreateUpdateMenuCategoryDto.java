package ru.rstdv.bmtf.dto.createupdate;

import java.util.List;

public record CreateUpdateMenuCategoryDto(
        String name,
        List<CreateUpdatePositionDto> createUpdatePositionDto
) {
}
