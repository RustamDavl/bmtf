package ru.rstdv.bmtf.dto.read;

import java.util.List;

public record ReadRestaurantDto(
        String id,
        String email,
        String name,
        List<ReadRestaurantScheduleDto> restaurantSchedules,
        ReadAddressDto readAddressDto,
        String paymentMethod,
        ReadOwnerDto readOwnerDto,
        List<ReadMenuCategoryDto> readMenuCategoryDtos,
        ReadContactDto readContactDto,
        String status


) {
}
