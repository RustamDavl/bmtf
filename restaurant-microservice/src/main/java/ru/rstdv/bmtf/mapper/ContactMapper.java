package ru.rstdv.bmtf.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdateContactDto;
import ru.rstdv.bmtf.dto.read.ReadContactDto;
import ru.rstdv.bmtf.entity.Contact;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ContactMapper {

    Contact toContact(CreateUpdateContactDto createUpdateContactDto);

    ReadContactDto toReadContactDto(Contact contact);
}
