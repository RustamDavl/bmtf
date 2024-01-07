package ru.rstdv.bmtf.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "customer_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private String street;
    private Short streetNumber;
    private Short doorwayNumber;
    private Short floorNumber;
    private Short flatNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) && Objects.equals(city, address.city) && Objects.equals(street, address.street) && Objects.equals(streetNumber, address.streetNumber) && Objects.equals(doorwayNumber, address.doorwayNumber) && Objects.equals(floorNumber, address.floorNumber) && Objects.equals(flatNumber, address.flatNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city, street, streetNumber, doorwayNumber, floorNumber, flatNumber);
    }
}
