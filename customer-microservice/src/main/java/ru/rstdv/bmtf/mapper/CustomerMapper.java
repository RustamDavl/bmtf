package ru.rstdv.bmtf.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdateCustomerDto;
import ru.rstdv.bmtf.dto.read.ReadCustomerDto;
import ru.rstdv.bmtf.entity.Customer;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
// without this strategy null fields from updateDTO will replace the same fields in target object
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(source = "addresses", target = "readAddressDtoList")
    ReadCustomerDto toReadCustomerDto(Customer customer);

    Customer toCustomer(CreateUpdateCustomerDto createUpdateCustomerDto);

    Customer updateCustomerFromDto(@MappingTarget Customer customer, CreateUpdateCustomerDto createUpdateCustomerDto);
}
