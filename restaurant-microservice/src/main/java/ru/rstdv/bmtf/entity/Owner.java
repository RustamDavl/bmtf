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
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String phone;
    private String password;

    @Builder.Default
    @ToString.Exclude
    @OneToMany(mappedBy = "owner")
    private List<Restaurant> restaurants = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return Objects.equals(id, owner.id) && Objects.equals(email, owner.email) && Objects.equals(phone, owner.phone) && Objects.equals(password, owner.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, phone, password);
    }
}
