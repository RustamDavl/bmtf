package ru.rstdv.bmtf.dto.read;

import java.util.List;

public record ReadCustomerDto(String id, String phone, String email,
                              List<ReadAddressDto> readAddressDtoList) {
}
