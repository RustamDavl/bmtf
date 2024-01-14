package ru.rstdv.bmtf.dto.createupdate;

public record CreateUpdateAddressDto(
        String city,
        String street,
        String houseNumber
) {
}
