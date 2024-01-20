package ru.rstdv.bmtf.dto.createupdate;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public record CreateUpdateRestaurantDto(
        String email,
        MultipartFile titlePhoto,

        String name,

        List<CreateUpdateRestaurantScheduleDto> createUpdateRestaurantScheduleDtos,

        CreateUpdateAddressDto createUpdateAddressDto,

        String paymentMethod,

        String ownerId,

        List<CreateUpdateMenuCategoryDto> createUpdateMenuCategoryDtos,

        CreateUpdateContactDto createUpdateContactDto
) {
}
