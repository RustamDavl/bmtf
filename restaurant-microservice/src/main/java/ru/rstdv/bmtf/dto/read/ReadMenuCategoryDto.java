package ru.rstdv.bmtf.dto.read;

import java.util.List;

public record ReadMenuCategoryDto(
        String id,
        String name,
        List<ReadPositionDto> readPositionDtos
) {
}
