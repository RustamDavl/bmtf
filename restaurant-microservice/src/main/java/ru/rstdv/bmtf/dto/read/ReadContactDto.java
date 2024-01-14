package ru.rstdv.bmtf.dto.read;

public record ReadContactDto(
        String id,

        String bossPhone,
        String commonPhone,
        String additionalPhone
) {
}
