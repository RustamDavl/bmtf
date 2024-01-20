package ru.rstdv.bmtf.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@ToString
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "boss", nullable = false)
    private String bossPhone;

    @Column(name = "common", nullable = false)
    private String commonPhone;

    @Column(name = "additional")
    private String additionalPhone;

    @OneToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(id, contact.id) && Objects.equals(bossPhone, contact.bossPhone) && Objects.equals(commonPhone, contact.commonPhone) && Objects.equals(additionalPhone, contact.additionalPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bossPhone, commonPhone, additionalPhone);
    }
}
