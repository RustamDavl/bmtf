package ru.rstdv.bmtf.entity;

import jakarta.persistence.*;
import jdk.jfr.Category;
import lombok.*;
import ru.rstdv.bmtf.entity.embeddable.PaymentMethod;
import ru.rstdv.bmtf.entity.embeddable.RestaurantStatus;

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
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    private byte[] titlePhoto;

    private String name;

    @Builder.Default
    @ToString.Exclude
    @OneToMany(mappedBy = "restaurant", cascade = {CascadeType.PERSIST})
    private List<RestaurantSchedule> restaurantSchedules = new ArrayList<>();

    @OneToOne(mappedBy = "restaurant", cascade = {CascadeType.PERSIST})
    private Address address;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @OneToMany(mappedBy = "restaurant", cascade = {CascadeType.PERSIST})
    @Builder.Default
    @ToString.Exclude
    private List<MenuCategory> categories = new ArrayList<>();

    @OneToOne(mappedBy = "restaurant", cascade = {CascadeType.PERSIST})
    private Contact contact;

    @Enumerated(EnumType.STRING)
    private RestaurantStatus status;

    public void addAllCategories(List<MenuCategory> categories) {
        this.categories.addAll(categories);
        categories.forEach(
                menuCategory -> menuCategory.setRestaurant(this)
        );
    }

    public void addAddress(Address address) {
        this.address = address;
        address.setRestaurant(this);
    }

    public void addContact(Contact contact) {
        this.contact = contact;
        contact.setRestaurant(this);
    }

    // TODO: 13.01.2024 add later  
//    @OneToMany(mappedBy = "restaurant")
//    @Builder.Default
//    @ToString.Exclude
//    private List<Review> reviews = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address);
    }
}
