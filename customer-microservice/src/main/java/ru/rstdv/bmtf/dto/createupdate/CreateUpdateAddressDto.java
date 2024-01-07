package ru.rstdv.bmtf.dto.createupdate;


public record CreateUpdateAddressDto(String city, String street, String streetNumber,
                                     String doorwayNumber, String floorNumber, String flatNumber) {
}
