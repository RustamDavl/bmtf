package ru.rstdv.bmtf.dto.createupdate;

import org.springframework.web.multipart.MultipartFile;

public record CreateUpdatePositionDto(
        String name,
        MultipartFile photo,
        String description,
        String weight
) {

}
