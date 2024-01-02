package ru.rstdv.bmtf.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {

    private String city;
    private String street;
    private Short streetNumber;
    private Short doorwayNumber;
    private Short floorNumber;
    private Short flatNumber;
}
