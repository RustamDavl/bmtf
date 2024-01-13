package ru.rstdv.bmtf.entity.embeddable;


import jakarta.persistence.Embeddable;
import lombok.*;

import java.util.Objects;


@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class WeekDays {

    private Boolean mon;
    private Boolean tue;
    private Boolean wed;
    private Boolean thur;
    private Boolean fri;
    private Boolean sat;
    private Boolean sun;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeekDays weekDays = (WeekDays) o;
        return Objects.equals(mon, weekDays.mon) && Objects.equals(tue, weekDays.tue) && Objects.equals(wed, weekDays.wed) && Objects.equals(thur, weekDays.thur) && Objects.equals(fri, weekDays.fri) && Objects.equals(sat, weekDays.sat) && Objects.equals(sun, weekDays.sun);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mon, tue, wed, thur, fri, sat, sun);
    }
}
