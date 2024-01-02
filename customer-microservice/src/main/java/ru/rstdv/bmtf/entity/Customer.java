package ru.rstdv.bmtf.entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String phone;

    private String email;

    private String password;

    @ToString.Exclude
    @Builder.Default
    @ElementCollection
    @CollectionTable(
            name = "customer_address",
            joinColumns = @JoinColumn(name = "customer_id")
    )
    private List<Address> addresses = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(phone, customer.phone) && Objects.equals(email, customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, phone, email);
    }

    //TODO : add card_info list for storing card details


}
