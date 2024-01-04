package ru.rstdv.bmtf.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import ru.rstdv.bmtf.dto.createupdate.CreateUpdateCustomerDto;
import ru.rstdv.bmtf.dto.read.ReadCustomerDto;
import ru.rstdv.bmtf.entity.Customer;
import ru.rstdv.bmtf.util.CountryCodeInjector;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
// without this strategy null fields from updateDTO will replace the same fields in target object
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(source = "addresses", target = "readAddressDtoList")
    @Mapping(source = "phone", target = "phone", qualifiedByName = "modifyPhoneWithCountryCode")
    ReadCustomerDto toReadCustomerDto(Customer customer);

    @Named("modifyPhoneWithCountryCode")
    default String modifyPhone(String originalPhone) {
        if (originalPhone.startsWith("+7"))
            return originalPhone.replace("+7", "");

        return CountryCodeInjector.injectCountryCode().concat(originalPhone);
    }

    @Mapping(source = "phone", target = "phone", qualifiedByName = "modifyPhoneWithCountryCode")
    Customer toCustomer(CreateUpdateCustomerDto createUpdateCustomerDto);

    Customer updateCustomerFromDto(@MappingTarget Customer customer, CreateUpdateCustomerDto createUpdateCustomerDto);
}
