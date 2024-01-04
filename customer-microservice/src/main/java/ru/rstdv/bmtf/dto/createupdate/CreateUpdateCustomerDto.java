package ru.rstdv.bmtf.dto.createupdate;

public record CreateUpdateCustomerDto(String firstName, String phone, String email, String password, CreateUpdateAddressDto createUpdateAddressDto) {
}
