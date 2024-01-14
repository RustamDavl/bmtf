package ru.rstdv.bmtf.dto.createupdate;

public record CreateUpdateRestaurantDto(
        String email,
        byte[] titlePhoto,

        String name,

        CreateUpdateRestaurantScheduleDto createUpdateRestaurantScheduleDto,

        CreateUpdateAddressDto createUpdateAddressDto,

        String paymentMethod,

        String ownerId,

        CreateUpdateMenuCategoryDto createUpdateMenuCategoryDto,

        CreateUpdateContactDto createUpdateContactDto
) {
}
