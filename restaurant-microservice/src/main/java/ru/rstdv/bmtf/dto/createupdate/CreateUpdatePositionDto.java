package ru.rstdv.bmtf.dto.createupdate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.web.multipart.MultipartFile;

@JsonIgnoreProperties({"photo"})
public record CreateUpdatePositionDto(
        String name,
        MultipartFile photo,
        String description,
        String weight,
        String menuCategoryId
) {
}
