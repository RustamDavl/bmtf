package ru.rstdv.bmtf.dto.read;

public record ReadAddressDto(String id, String city, String street, String streetNumber,
                             String doorwayNumber, String floorNumber, String flatNumber) {
}
