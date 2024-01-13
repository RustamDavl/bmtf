package ru.rstdv.bmtf.entity;

import jakarta.persistence.*;
import lombok.*;
import ru.rstdv.bmtf.entity.embeddable.WeekDays;
import ru.rstdv.bmtf.entity.embeddable.WorkingHours;

import java.util.Objects;


@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private WeekDays weekDays;

    @Embedded
    private WorkingHours workingHours;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestaurantSchedule that = (RestaurantSchedule) o;
        return Objects.equals(id, that.id) && Objects.equals(weekDays, that.weekDays) && Objects.equals(workingHours, that.workingHours);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, weekDays, workingHours);
    }
}
