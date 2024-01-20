package ru.rstdv.bmtf.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdateAddressDto;
import ru.rstdv.bmtf.dto.read.ReadAddressDto;
import ru.rstdv.bmtf.entity.Address;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AddressMapper {

    ReadAddressDto toReadAddressDto(Address address);

    Address toAddress(CreateUpdateAddressDto createUpdateAddressDto);

    Address updateAddressFromDto(@MappingTarget Address address, CreateUpdateAddressDto createUpdateAddressDto);
}
