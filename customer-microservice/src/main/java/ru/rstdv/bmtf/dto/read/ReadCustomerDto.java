package ru.rstdv.bmtf.dto.read;

import java.util.List;

public record ReadCustomerDto(String id, String firstName, String phone, String email,
                              List<ReadAddressDto> readAddressDtoList) {
}
