package ru.rstdv.bmtf.dto.createupdate;

public record CreateUpdateMenuCategoryDto(
        String name,
        CreateUpdatePositionDto createUpdatePositionDto
) {
}
