package ru.rstdv.bmtf.dto.createupdate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.web.multipart.MultipartFile;

/**
 * class represents only common info about restaurant
 */

@JsonIgnoreProperties({"titlePhoto"})
public record CreateUpdateRestaurantDto(
        String email,
        MultipartFile titlePhoto,

        String name,
        CreateUpdateAddressDto createUpdateAddressDto,

        String paymentMethod,

        String ownerId,

        CreateUpdateContactDto createUpdateContactDto
) {
}
